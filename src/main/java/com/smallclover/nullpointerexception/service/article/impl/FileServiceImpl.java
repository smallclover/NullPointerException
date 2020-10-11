package com.smallclover.nullpointerexception.service.article.impl;

import com.smallclover.nullpointerexception.exception.FileException;
import com.smallclover.nullpointerexception.property.NPEResourcesProperties;
import com.smallclover.nullpointerexception.service.article.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 上传文件存储
 * @Author: Amadeus
 * @Date: 2020/5/10 18:01
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    // 上传文件存储路径
    private final Path fileStoreLocation;


    public FileServiceImpl(NPEResourcesProperties NPEResourcesProperties) {
        // .normalize()标准化路径
        this.fileStoreLocation = Paths.get(NPEResourcesProperties.getArticleImgPath()).toAbsolutePath().normalize();
        log.info("文件存储路径:{}",fileStoreLocation.toString());
        try {
            Files.createDirectories(this.fileStoreLocation);
        } catch (IOException e) {
            throw new FileException("无法创建目录", e);
        }
    }


    /**
     * 文件存储
     * @param file
     * @return
     */
    @Override
    public String storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path targetLocation = this.fileStoreLocation.resolve(fileName);
        log.info("文件名:{}",fileName);
        log.info("存储目标路径:{}",targetLocation);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            throw new FileException("文件存储失败", e);
        }
    }
}
