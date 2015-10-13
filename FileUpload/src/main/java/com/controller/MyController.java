package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.model.FileModel;

@Controller
public class MyController  {
	
	@RequestMapping(value="/")
	public String grtForm()
	{
		return "upload";
	}
	
	
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	
	
		    public String save(@ModelAttribute("uploadForm") FileModel uploadForm,
	
		            Model map) {
	
		 
		 InputStream inputStream = null;  
		  OutputStream outputStream = null; 
		        MultipartFile multipartFile = uploadForm.getFile();
	
		 System.out.println(multipartFile);
	
		        String fileName = "";

		 try{
	
		        if (multipartFile != null) {
		        	byte[] bytes = multipartFile.getBytes();
	System.out.println("hello");
		            fileName = multipartFile.getOriginalFilename();
		            System.out.println(fileName);
		            
		            
		            String rootPath = System.getProperty("catalina.home");
	                File dir = new File(rootPath + File.separator + "tmpFiles");
	                if (!dir.exists())
	                    dir.mkdirs();
	 
	                // Create the file on server
	                File serverFile = new File(dir.getAbsolutePath());
	                BufferedOutputStream stream = new BufferedOutputStream(
	                        new FileOutputStream(serverFile));
	                stream.write(bytes);
	                stream.close();
	
		        }
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	
		        map.addAttribute("files", fileName);
		        map.addAttribute("message", "Successfully uploaded");
	           return "success";
	
		    }
	
	
	
	
	
	

	/*public String uploadFile(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file, ModelMap model)
            {
		if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();*/
 
                // Creating the directory to store file
              /*  String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();*/
 
                // Create the file on server
              /*  File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);*/
              /*  File serverFile=new File("D:/");
                if (!serverFile.exists()) {  
                	serverFile.createNewFile();  
                   }  
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                
                model.addAttribute("messgae", "You successfully uploaded file=" + name);
              
 
               
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
        	model.addAttribute("messgae", "You failed to upload " + name
                    + " because the file was empty.");
           
        }
		
		return "success";
            }
*/
                
                
                
                
}
