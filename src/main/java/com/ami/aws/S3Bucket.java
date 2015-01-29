package com.ami.aws;

import java.util.List;

import org.testng.annotations.Test;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class S3Bucket {

	private static final String bucketName     = "olxlogs";
	
	private static final String Aws_Access_Key = System.getProperty("AWS_KEY");
	private static final String Aws_Secret_Key = System
			.getProperty("AWS_SECRET");

static
{
	System.out.println("printing key" + Aws_Access_Key);
	System.out.println("printing key" + Aws_Secret_Key);
}
	// public static void main(String[] args) throws IOException {
	// Instantiate the S3 client with your AWS credentials
	@Test
	public void test() {

		System.out.println("printing key" + Aws_Access_Key);
		System.out.println("printing key" + Aws_Secret_Key);
		AmazonS3 s3 = new AmazonS3Client(new BasicAWSCredentials(
	               Aws_Access_Key, Aws_Secret_Key));
		
		List<Bucket> buck = s3.listBuckets();
		System.out.println("printing the bucket in AWS" + buck);

}

}