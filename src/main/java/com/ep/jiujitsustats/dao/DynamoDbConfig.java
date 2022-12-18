//    package com.ep.jiujitsustats.dao;
//
//    import org.springframework.beans.factory.annotation.Value;
//    import org.springframework.context.annotation.Bean;
//    import org.springframework.context.annotation.Configuration;
//
//    @Configuration
//    public class DynamoDbConfig {
//
//        @Value("${aws.access.key}")
//        private String awsAccessKey;
//
//        @Value("${aws.access.secret-key}")
//        private String awsSecretKey;
//
//        @Value("${aws.dynamodb.endpoint}")
//        private String awsDynamoDBEndPoint;
//
//        @Value("${aws.region:}")
//        private String awsRegion;
//
//        @Bean
//        public AWSCredentials amazonAWSCredentials(){
//            return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
//        }
//        public AWSCredentialsProvider amazonAWSCredentialsProvider(){
//            return new AWSStaticCredentialsProvider(amazonAWSCredentials());
//        }
//        // Returns the amazonDB instance using the endpoint as well as credentials
//        public AmazonDynamoDB amazonDynamoDB(){
//            return AmazonDynamoDBClientBuilder.standard()
//                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamoDBEndPoint, awsRegion))
//                    .withCredentials(amazonAWSCredentialsProvider())
//                    .build();
//        }
//
//        @Bean
//        public DynamoDBMapper mapper(){
//            return new DynamoDBMapper(amazonDynamoDB());
//        }
//    }