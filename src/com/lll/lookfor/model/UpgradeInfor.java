/*
 * 文件名称 : UpgradeInfor.java
 * <p>
 * 作者信息 : hc
 * <p>
 * 创建时间 : 2014-8-12, 下午2:10:11
 * <p>
 * 评审记录 :
 * <p>
 */

package com.lll.lookfor.model;

import java.io.Serializable;

/**
 * 升级返回信息类
 * <p>
 */
public class UpgradeInfor implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 升级方式 0：无需升级 1：需要立即强制升级 2：提示升级
     */
    private int upgradeStrategy;
    
    /**
     * 升级版本号(规则需要定义)
     */
    private String upgradeVersionNo;
    
    /**
     * 升级方式 0 HTTP 1 FTP
     */
    private int urlType;
    
    /**
     * 升级软件包地址采用http方式 ,如果是FTP为IP地址
     */
    private String fileUrl;
    
    /**
     * 升级软件包Hash值。为md5值。
     */
    private String fileHash;
    
    /**
     * 软件大小，单位字节
     */
    private int fileSize;
    
    /**
     * 访问用户名
     */
    private String accessUser;
    
    /**
     * 访问密码
     */
    private String accessPwd;
    
    /**
     * 版本信息描述
     */
    private String versionDesc;
    
    /**
     * 压缩方式： 0-无 1:tar; 2:zip
     */
    private String  compressType;
    
    public int getUpgradeStrategy()
    {
        return upgradeStrategy;
    }
    
    public void setUpgradeStrategy(int upgradeStrategy)
    {
        this.upgradeStrategy = upgradeStrategy;
    }
    
    public String getUpgradeVersionNo()
    {
        return upgradeVersionNo;
    }
    
    public void setUpgradeVersionNo(String upgradeVersionNo)
    {
        this.upgradeVersionNo = upgradeVersionNo;
    }
    
    public int getUrlType()
    {
        return urlType;
    }
    
    public void setUrlType(int urlType)
    {
        this.urlType = urlType;
    }
    
    public String getFileUrl()
    {
        return fileUrl;
    }
    
    public void setFileUrl(String fileUrl)
    {
        this.fileUrl = fileUrl;
    }
    
    public String getFileHash()
    {
        return fileHash;
    }
    
    public void setFileHash(String fileHash)
    {
        this.fileHash = fileHash;
    }
    
    public int getFileSize()
    {
        return fileSize;
    }
    
    public void setFileSize(int fileSize)
    {
        this.fileSize = fileSize;
    }
    
    public String getAccessUser()
    {
        return accessUser;
    }
    
    public void setAccessUser(String accessUser)
    {
        this.accessUser = accessUser;
    }
    
    public String getAccessPwd()
    {
        return accessPwd;
    }
    
    public void setAccessPwd(String accessPwd)
    {
        this.accessPwd = accessPwd;
    }
    
    public String getVersionDesc()
    {
        return versionDesc;
    }
    
    public void setVersionDesc(String versionDesc)
    {
        this.versionDesc = versionDesc;
    }
    
    public String getCompressType()
    {
        return compressType;
    }
    
    public void setCompressType(String compressType)
    {
        this.compressType = compressType;
    }
    
    @Override
    public String toString()
    {
        return "UpgradeInfor [upgradeStrategy=" + upgradeStrategy
                + ", upgradeVersionNo=" + upgradeVersionNo + ", urlType="
                + urlType + ", fileUrl=" + fileUrl + ", fileHash=" + fileHash
                + ", fileSize=" + fileSize + ", accessUser=" + accessUser
                + ", accessPwd=" + accessPwd + ", versionDesc=" + versionDesc
                + ", compressType=" + compressType + "]";
    }
    
}
