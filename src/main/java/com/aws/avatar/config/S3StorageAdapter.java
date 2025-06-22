package com.aws.avatar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Configuration
public class S3StorageAdapter {

    private final S3Client s3Client;
    private final String bucketName;
    private final String region;


    public S3StorageAdapter(@Value("${aws.region}") String region,
                            @Value("${aws.bucket.name}") String bucketName) {
        this.bucketName = bucketName;
        this.region = region;
        this.s3Client = S3Client.builder()
                .region(Region.of(this.region))
                .build();
    }

    public String uploadFile(final byte[] fileData, final String fileName, final String contentType) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(contentType)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(fileData));

        return String.format("https://%s.s3.%s.amazonaws.com/%s",
                bucketName, region, fileName);
    }
}
