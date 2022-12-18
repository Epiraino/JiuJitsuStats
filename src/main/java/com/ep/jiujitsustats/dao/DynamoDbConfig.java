    package com.ep.jiujitsustats.dao;

    import com.amazonaws.auth.AWSCredentials;
    import com.amazonaws.auth.AWSCredentialsProvider;
    import com.amazonaws.auth.AWSStaticCredentialsProvider;
    import com.amazonaws.auth.BasicAWSCredentials;
    import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
    import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
    import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
    import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import software.amazon.awssdk.awscore.client.builder.AwsClientBuilder;
    import software.amazon.awssdk.utils.StringUtils;

    @Configuration
    public class DynamoDbConfig {

        @Value("${aws.access.key}")
        private String awsAccessKey;

        @Value("${aws.access.secret-key}")
        private String awsSecretKey;

        @Value("${aws.dynamodb.endpoint}")
        private String awsDynamoDBEndPoint;

        @Value("${aws.region:}")
        private String awsRegion;

        @Bean
        public AWSCredentials amazonAWSCredentials(){
            return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        }
        public AWSCredentialsProvider amazonAWSCredentialsProvider(){
            return new AWSStaticCredentialsProvider(amazonAWSCredentials());
        }
        // Returns the amazonDB instance using the endpoint as well as credentials
        public AmazonDynamoDB amazonDynamoDB() {
            AmazonDynamoDB amazonDynamoDB
                    = new AmazonDynamoDBClient(amazonAWSCredentials());

            if (!StringUtils.isEmpty(awsDynamoDBEndPoint)) {
                amazonDynamoDB.setEndpoint(awsDynamoDBEndPoint);
            }

            return amazonDynamoDB;
        }
        @Bean
        public DynamoDBMapper mapper(){
            return new DynamoDBMapper(amazonDynamoDB());
        }
    }