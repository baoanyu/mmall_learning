package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * IFileService
 *
 * @author bay
 * @date 2019-05-22-0022 16:04
 */
public interface IFileService {

    /**
     * 文件上传接口
     *
     * @param file
     * @param path
     * @return
     */
    String upload(MultipartFile file, String path);
}
