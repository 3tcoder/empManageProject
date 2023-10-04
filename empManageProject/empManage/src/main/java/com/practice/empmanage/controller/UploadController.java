package com.practice.empmanage.controller;

import com.practice.empmanage.pojo.Result;
import com.practice.empmanage.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping()
    public Result upload(MultipartFile image) throws IOException {
        log.info("upload " + image);
        String url = aliOSSUtils.upload(image);
        return Result.success(url);
    }
}
