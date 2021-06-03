package project.hrms.core.utilities.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService {

	
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}


	@Override
	public DataResult<?> add(MultipartFile multipleFile) {
	
	try {
		 Map cloudinaryAdded = this.cloudinary.uploader().upload(multipleFile.getBytes(),ObjectUtils.emptyMap());
		 return new SuccessDataResult<Map>(cloudinaryAdded) ;
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	 
	 return new ErrorDataResult<Map>() ;
	}

}
