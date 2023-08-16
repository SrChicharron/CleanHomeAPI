package com.pandemuerto.CleanHome.service.impl;

import com.jcraft.jsch.*;
import com.pandemuerto.CleanHome.service.IFileTransferService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class FileTransferService implements IFileTransferService {
    @Value("${sftp.host}")
    private String SFTP_HOST;
    @Value("${knf.secret2}")
    private static final int SFTP_PORT=22;
    @Value("${sftp.user}")
    private String SFTP_USER;
    @Value("${sftp.pass}")
    private String SFTP_PASSWORD;
    @Value("${sftp.directory}")
    private String REMOTE_PATH;

    @Override
    public void uploadImage(Map<String, MultipartFile> fotos) throws JSchException, RuntimeException {
        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channelSftp = null;

        try {
            session = jsch.getSession(SFTP_USER, SFTP_HOST, SFTP_PORT);
            session.setPassword(SFTP_PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            ChannelSftp finalChannelSftp = channelSftp;
            fotos.forEach((s, multipartFile) -> {
                try {
                    finalChannelSftp.put(multipartFile.getInputStream(),REMOTE_PATH+s);
                } catch (SftpException | IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } finally {
            if (channelSftp != null) {
                channelSftp.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }

    @Override
    public void uploadImage(MultipartFile foto, String nombre) throws JSchException, RuntimeException {
        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channelSftp = null;

        try {
            session = jsch.getSession(SFTP_USER, SFTP_HOST, SFTP_PORT);
            session.setPassword(SFTP_PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            ChannelSftp finalChannelSftp = channelSftp;
                try {
                    finalChannelSftp.put(foto.getInputStream(),REMOTE_PATH+nombre);
                } catch (SftpException | IOException e) {
                    throw new RuntimeException(e);
                }

        } finally {
            if (channelSftp != null) {
                channelSftp.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }
}
