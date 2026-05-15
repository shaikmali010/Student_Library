package model;

public class Book {

    private int id;
    private String title;
    private String author;
    private int studentId;
    private String issueDate;

    public Book() {

    }

    public Book(
            int id,
            String title,
            String author,
            int studentId,
            String issueDate) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.studentId = studentId;
        this.issueDate = issueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author=author;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId=studentId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate=issueDate;
    }

}