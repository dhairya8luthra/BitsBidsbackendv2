package com.example.auctionapp.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@PropertySource("classpath:s3config.properties")
public class S3Config {
    @Value("${bucketName}")
    private String BucketName;

    @Value("${bucketRegion}")
    private String BucketRegion;
    @Value("${AWS_ACCESS_KEY_ID}")
    private String accessKeyId;
    @Value("${AWS_SECRET_ACCESS_KEY}}")
    private String SecretaccessKeyId;

    @Bean
    public AmazonS3 getS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials("AKIAXDJNKBDUA7QYCBK5",
                "lzKZPCeCsSZDr6DxD05hmTPPWs/r4gbtOyS0sN7Z");
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(BucketRegion).build();
    }

    public String getBucketName() {
        return this.BucketName;
    }

    public String getBucketRegion() {
        return this.BucketRegion;
    }

}
