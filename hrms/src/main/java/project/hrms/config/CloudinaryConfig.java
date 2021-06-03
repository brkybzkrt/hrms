package project.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import project.hrms.core.utilities.cloudinary.CloudinaryManager;
import project.hrms.core.utilities.cloudinary.CloudinaryService;

@Configuration
public class CloudinaryConfig {

	@Bean
	public Cloudinary user() {
		
		
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "AhmetBerkayBozkurt", 
                "api_key", "457564262298427",
                "api_secret", "rWaG_Mu4mcTSN4x8KjbufOu70R4"
				
				));
		
	}
	
	
	@Bean
	public CloudinaryService cloudinaryService() {
		
		return new CloudinaryManager(user());
	}
}
