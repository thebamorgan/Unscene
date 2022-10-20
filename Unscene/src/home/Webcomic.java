/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package home;

/**
 *
 * @author Zander
 */
public class Webcomic {
    String Title;
    String Genre; // Genre - Genre of webcomic || Think about making it possible to have multiple genres
    String Artist; // Think about making it possible to store multiple artists. Temporary solution: "John Doe & Jane Doe"
    String Desc; // Desc - Description of webcomic
    /*File*/ Art; // Art - General Thumbnail or artwork for the entire webcomic
    int NumPagT; // The total number of pages in a webcomic
    int NumPagR; // The number of pages the user has read in this webcomic
    boolean Viewed; // Has the user seen the most recent page or upload? 0 = No, 1 = Yes
    boolean Interested; // Is the user interested in this webcomic? 0 = No, 1 = Yes
    /* Methods ************************************************************************************
    * Update Viewed - When user has read the most recent page of the webcomic (Viewed)
    * Update Read - Change the number of pages the user has read (NumPagR)
    * Update Interest - Change the boolean value when the user expresses interes in this webcomic (Interested)
    */
}
