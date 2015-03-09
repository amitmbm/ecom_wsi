package com.ami.aws;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/*
 * commenting as it is threat to AWS account , as well deleting.
 */

@Component
public class S3Bucket {

	private static final String bucketName     = "olxlogs";
	
/*	private static final String Aws_Access_Key = System.getProperty("AWS_KEY");
	private static final String Aws_Secret_Key = System
			.getProperty("AWS_SECRET");*/

	@PostConstruct
	public void printS3Bucket()
	{
		/*System.out.println("printing key" + Aws_Access_Key);
		System.out.println("printing key" + Aws_Secret_Key);
		System.out.println("printing key" + Aws_Access_Key);
		System.out.println("printing key" + Aws_Secret_Key);
		AmazonS3 s3 = new AmazonS3Client(new BasicAWSCredentials(
	               Aws_Access_Key, Aws_Secret_Key));
		
		List<Bucket> buck = s3.listBuckets();
		System.out.println("printing the bucket in AWS" + buck);*/
	}


}