/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Alisson
 */
public class MessageLabel {
    private String type;
    private String body;
    private String title;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setMessageType(boolean success, String title, String body){
        this.setBody(body);
        this.setTitle(title);
        if(success){
            this.type = "success";
        }else{
            this.type = "danger";
        }
    }
    
}
