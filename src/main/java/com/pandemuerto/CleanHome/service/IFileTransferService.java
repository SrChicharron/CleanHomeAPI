package com.pandemuerto.CleanHome.service;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Map;

public interface IFileTransferService {
    void uploadImage(Map<String, MultipartFile> fotos, Map<String,MultipartFile> comprobantes) throws JSchException, RuntimeException;
}
