package com.blobs.quickstart;

/**
 * Azure blob storage v12 SDK quickstart
 */

import java.io.*;
import com.azure.storage.blob.*;
import com.azure.storage.blob.models.BlobContainerItem;
import com.azure.storage.blob.models.BlobItem;
import com.azure.identity.*;

public class App
{
    public static void main( String[] args ) throws IOException
    {
    	
    	BlobServiceClient blobStorageClient = new BlobServiceClientBuilder()
    		    .endpoint("https://12567teststg.blob.core.windows.net/staticfiles")
    		    .credential(new DefaultAzureCredentialBuilder().build())
    		    .buildClient();
    	System.out.println("BlobService CLient Account URL..... "+blobStorageClient.getAccountUrl());
    	System.out.println("BlobService CLient list containers..... "+blobStorageClient.listBlobContainers());
    	
    	System.out.println("\nListing blobs...");

    	
    	// List the blob(s) in the container.
    	BlobContainerClient containerClient = blobStorageClient.getBlobContainerClient("staticfiles");
    	System.out.println("\nListing blobs 2222...");

    	System.out.println("\nListing blobs 2222's..."+containerClient.getBlobContainerUrl());
    	
    	for (BlobItem blobItem : containerClient.listBlobs()) {
    	    System.out.println("\t" + blobItem.getName());
    	}
    	
    	    
    	}
    }
