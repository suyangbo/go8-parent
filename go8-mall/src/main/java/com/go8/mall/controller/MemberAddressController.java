package com.go8.mall.controller;

import org.springframework.stereotype.Controller;
/*import com.go8.sso.pojo.MemberAddress;
import com.go8.sso.service.MemberAddressService;*/

@Controller
public class MemberAddressController {
	/*@Autowired
	private MemberAddressService memberAddressService;*/
	
	/*@GetMapping("/address")
	public @ResponseBody Object getAddresses(long memberId){
		try {
			List<MemberAddress> addresses = memberAddressService.getAddresses(memberId);
			return ServiceResponse.ok(addresses);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@PostMapping("/address/add")
	public @ResponseBody Object add(MemberAddress memberAddress){
		try {
			memberAddressService.add(memberAddress);
			return ServiceResponse.ok(memberAddress);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}*/
}
