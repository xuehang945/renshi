package com.renshiproject.dataobject;

public class FileDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file.file_id
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    private Integer fileId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file.file_name
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    private String fileName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file.type
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file.file_path
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    private String filePath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column file.file_number
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    private Integer fileNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file.file_id
     *
     * @return the value of file.file_id
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file.file_id
     *
     * @param fileId the value for file.file_id
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file.file_name
     *
     * @return the value of file.file_name
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file.file_name
     *
     * @param fileName the value for file.file_name
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file.type
     *
     * @return the value of file.type
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file.type
     *
     * @param type the value for file.type
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file.file_path
     *
     * @return the value of file.file_path
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file.file_path
     *
     * @param filePath the value for file.file_path
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file.file_number
     *
     * @return the value of file.file_number
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    public Integer getFileNumber() {
        return fileNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file.file_number
     *
     * @param fileNumber the value for file.file_number
     *
     * @mbg.generated Sat Jun 29 09:14:49 CST 2019
     */
    public void setFileNumber(Integer fileNumber) {
        this.fileNumber = fileNumber;
    }
}