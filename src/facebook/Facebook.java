/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebook;

import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Facebook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Metodos tf= new Metodos();
        int menu;
        tf.autorizar();
        do {
         menu=Integer.parseInt(JOptionPane.showInputDialog("1.Publicar estado \n 2.Subir foto \n 3.Buscar un tema \n 4.Comentar foto"));  
         switch(menu){
             case 1:
                  tf.publicar(JOptionPane.showInputDialog("mensaje"));
                 break;
             case 2:
                 tf.foto(JOptionPane.showInputDialog("URL"));
                 break;
             case 3:
                 tf.buscartema(JOptionPane.showInputDialog("tema"));
                 break;
             case 4:
                 tf.comentarioFoto(JOptionPane.showInputDialog("Mensaje"));
                 break;
                 
         }
        }while(menu!=0);

    }
    }
    

