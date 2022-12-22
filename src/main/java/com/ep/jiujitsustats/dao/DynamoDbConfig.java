    package com.ep.jiujitsustats.dao;

    import com.amazonaws.auth.*;
    import com.amazonaws.auth.profile.ProfileCredentialsProvider;
    import com.amazonaws.client.builder.AwsClientBuilder;
    import com.amazonaws.regions.Regions;
    import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
    import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
    import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
    import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
    import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
    import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
    import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
    import software.amazon.awssdk.regions.Region;
    import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
    import software.amazon.awssdk.utils.StringUtils;

    @Configuration
    public class DynamoDbConfig {

        @Bean
        public DynamoDbClient getDynamoDbClient() {
            AwsCredentialsProvider credentialsProvider =
                    DefaultCredentialsProvider.builder()
                            .profileName("default")
                            .build();

            return DynamoDbClient.builder()
                    .region(Region.US_WEST_2)
                    .credentialsProvider(credentialsProvider).build();
        }

        @Bean
        public DynamoDbEnhancedClient getDynamoDbEnhancedClient() {
            return DynamoDbEnhancedClient.builder()
                    .dynamoDbClient(getDynamoDbClient())
                    .build();
        }

    }