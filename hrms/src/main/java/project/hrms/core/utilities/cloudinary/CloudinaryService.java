package project.hrms.core.utilities.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import project.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	DataResult<?> add(MultipartFile multipleFile);
}
