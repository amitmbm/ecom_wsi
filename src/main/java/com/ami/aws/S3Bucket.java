package com.ami.aws;

import java.io.IOException;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3Bucket {

	private static final String bucketName     = "olxlogs";
	private static final String Aws_Access_Key        = "AKIAJXDFWNUJSMFHNXIA";
	private static final String Aws_Secret_Key = "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";
	private static final String key = "custom";
	private static final String File_To_Save = " C://Users//kh1871//Desktop//trial_link.txt";
	
	public static void main(String[] args) throws IOException {
	// Instantiate the S3 client with your AWS credentials
	AmazonS3 s3 = new AmazonS3Client(new BasicAWSCredentials(
	               Aws_Access_Key, Aws_Secret_Key));
	 
	// If you want to create bucket
	// bucketName: name of the bucket
	// s3.createBucket(bucketName);
	 
	// bucketName: Amazon Bucket Name 
	// key: The file location that you want to create for your file.
	// e.g, key = "user/appName/myapp.zip" 
	// File_To_Save: The location of your file.
	 
	PutObjectRequest objectFile = new PutObjectRequest(
			    bucketName, key, File_To_Save); 
	 
	// Set Access Control List 
	AccessControlList acl = new AccessControlList(); 
	acl.grantPermission(GroupGrantee.AllUsers, 
	            com.amazonaws.services.s3.model.Permission.Write); 
	objectFile.setAccessControlList(acl); 
	 
	// push file to s3 
	s3.putObject(objectFile);
}

}