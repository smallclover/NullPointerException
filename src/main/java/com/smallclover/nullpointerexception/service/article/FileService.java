package com.smallclover.nullpointerexception.service.article;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Amadeus
 * @Date: 2020/5/10 17:48
 */
public interface FileService {

    public String storeFile(MultipartFile file);
}
