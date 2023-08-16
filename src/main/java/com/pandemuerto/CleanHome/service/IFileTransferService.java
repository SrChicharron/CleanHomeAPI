package com.pandemuerto.CleanHome.service;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Map;

public interface IFileTransferService {
    void uploadImage(Map<String, MultipartFile> fotos) throws JSchException, RuntimeException;
    void uploadImage(MultipartFile foto,String nombre) throws JSchException, RuntimeException;
}
