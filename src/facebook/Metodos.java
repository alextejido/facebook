/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Group;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Metodos {
      static Facebook facebook;
/**
 * permission to use facebook api
 */
    public void autorizar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("763164400511077")
                .setOAuthAppSecret("7bdbb9bcd3664718efb05d19ce0ee6f7")
                .setOAuthAccessToken("EAAK2GA7ZCaGUBAHb2MZAyBgHcp3DQZA7hUXMYim7uaJizm13OK2UVGueIYVbuRu8tqx0RqxUDKYGBw7VZAbFZAWGSH25gIRVjloy4qZAOGMd6fpJZA8v1o7BlZCTXpqebH7D9rbonVfiMC4lCHJXI7csah9cZBGYZCpPT0shNNkzkR8UOeBahiTRmUJDY7iLhBMkfvlrWKHxvZBGXyaufF2sRTiO74xkv69ZCSkZD")
                .setOAuthPermissions("email,publish_stream,publish_actions,user_likes,user_status,user_about_me,user_photos,user_posts");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }
/**
 * make a post
 * @param mensaje massege that u wanna post in your status of fracebook
 */
    public void publicar(String mensaje) {
        try {
            facebook.postStatusMessage(mensaje);
        } catch (FacebookException ex) {
            System.out.println("error 1" + ex.getMessage());
        }
    }
/**
 * Method to give like

 */
    public void like() {
        try {
  
            facebook.likePost(facebook.getId());
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    /**
     * Method to upload a photo
     * @param url Is the route of the photo that you want to upload
     */
    public void foto(String url){
        try {
            PostUpdate post = null;
            try {
                post = new PostUpdate(new URL("http://facebook4j.org"))
                        .picture(new URL(JOptionPane.showInputDialog(url)))
                        .name(JOptionPane.showInputDialog("Titulo de la imagen"))
                        .caption(JOptionPane.showInputDialog("Subtitulo de la imagen"))
                        .description(JOptionPane.showInputDialog("Descripcion para la imagen"));
            } catch (MalformedURLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
            facebook.postFeed(post);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /** 
     * Method to make a comment
     * @param mensaje message that u want to send
     */
    public void comentarioFoto(String mensaje){
        try {
            facebook.commentPhoto("502857733438316", mensaje);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Method to find all post from a group
     * @param mensaje group to find
     */
    public void buscartema(String mensaje){
        try {
            ResponseList<Group> results = facebook.searchGroups(mensaje);
            for(int i=0;i<results.size();i++)
                System.out.println(results.get(i));
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * commets that a post have
     */
    public void comentariospost(){
        try {
           ResponseList<Comment> results = facebook.getCommentReplies("11422827368");
             for(int i=0;i<results.size();i++)
                System.out.println(results.get(i));
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
