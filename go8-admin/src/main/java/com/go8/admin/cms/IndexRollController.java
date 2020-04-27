package com.go8.admin.cms;

import com.go8.admin.common.service.ServiceResponse;
import com.go8.cms.pojo.IndexRoll;
import com.go8.cms.service.IndexRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController("adminIndexRollController")
@RequestMapping("/admin")
public class IndexRollController {
	@Autowired
	private IndexRollService indexRollService;
	
	@GetMapping("/indexroll")
	public Object getIndexRolls() {
		try {
			List<IndexRoll> rolls = indexRollService.getIndexRolls();
			return ServiceResponse.ok(rolls);
		}catch(Exception e) {
			return ServiceResponse.error();
		}
	}
	
	/**
	 * 添加功能
	 * @param roll
	 * @return
	 */
	@PostMapping("indexroll")
	public Object addIndexRoll(@RequestBody IndexRoll roll) {
		try {
			indexRollService.add(roll);
			return ServiceResponse.ok(roll);
		}catch(Exception e) {
			return ServiceResponse.error();
		}
	}
	
	@PutMapping("indexroll")
	public Object updateIndexRoll(@RequestBody IndexRoll roll) {
		try {
			indexRollService.update(roll);
			return ServiceResponse.ok();
		}catch(Exception e) {
			return ServiceResponse.error();
		}
	}
	
	@DeleteMapping("indexroll")
	public Object deleteIndexRoll(Long id) {
		try {
			indexRollService.delete(id);
			return ServiceResponse.ok();
		}catch(Exception e) {
			return ServiceResponse.error();
		}
	}
}