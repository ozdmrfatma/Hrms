package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service

public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobPositionDao) {
		super();
		this.jobTitleDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), " İş pozisyonları listelendi");
	}


	@Override
	public Result add(JobTitle jobTitle) {
		
		JobTitle result=this.jobTitleDao.getByTitle(jobTitle.getTitle());  //tekrar eden jobtitle için kontrol
		
		if(!(result==null)) {
			return new ErrorResult("Tekrar eden iş pozisyonu !");
		}
		
		jobTitleDao.save(jobTitle);
		return new SuccessResult(jobTitle.getTitle()+" iş pozisyonu eklendi ");
			
	}

	@Override
	public DataResult<JobTitle> getJobByTitle(String title) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.getByTitle(title),title+" Getirildi");
	}

	

	


}
