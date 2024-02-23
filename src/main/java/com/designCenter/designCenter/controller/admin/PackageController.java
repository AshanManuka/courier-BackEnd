package com.designCenter.designCenter.controller.admin;

import com.designCenter.designCenter.dto.common.CommonResponse;
import com.designCenter.designCenter.dto.packs.PackageReqDto;
import com.designCenter.designCenter.service.PackageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/loggedUser")
@Log4j2
@RequiredArgsConstructor
public class PackageController {

    private final PackageService packageService;

    @GetMapping(value = "/hello")
    public ResponseEntity<?> sample(){
        log.info("Check API");
        return ResponseEntity.ok(new CommonResponse<>(true,"Welcome User"));
    }

    @PostMapping(value = "/package")
    public ResponseEntity<?> savePackage(@RequestBody PackageReqDto packageReqDto){
        log.info("Saving new package from {} Hub to {} Hub",packageReqDto.getStartHub(),packageReqDto.getFinalHub());
        String packageCode = packageService.savePackageDetail(packageReqDto);
        return ResponseEntity.ok(new CommonResponse<>(true,packageCode));

    }
}
