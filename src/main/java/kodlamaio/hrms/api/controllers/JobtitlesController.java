package kodlamaio.hrms.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobTitle;


@RestController
@RequestMapping("/api/jobtitles")
public class JobtitlesController{
	
		private JobTitleService jobTitleService;
		
		@Autowired
		public JobtitlesController(JobTitleService jobTitleService) {
			super();
			this.jobTitleService = jobTitleService;
		}
		
		@GetMapping("/getall")
		public DataResult<List<JobTitle>>getAll(){
			return this.jobTitleService.getAll();
		}
		
		@GetMapping("/getById")
		public DataResult<JobTitle>getById(int id){
			return (this.jobTitleService.getById(id));
		}
}
