package action;

import java.io.File;

import service.ProfileServiceImpl;

import com.opensymphony.xwork2.ActionSupport;


/*
 * I haven't used this class anywhere.
 * Follow this :
 * http://viralpatel.net/blogs/struts-2-file-upload-save-tutorial-with-example/
 */
@SuppressWarnings("serial")
public class ImageUpload extends ActionSupport {

    File profilePicture;
    String contentType;
    String fileName;

    public String execute() {
        return SUCCESS;
    }

    /**
     * @return the profilePicture
     */
    public File getProfilePicture() {
        return profilePicture;
    }

    /**
     * @param profilePicture the profilePicture to set
     */
    public void setProfilePicture(File profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }



}
