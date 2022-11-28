package home;

import java.util.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author salwajeries
 */
public class DisplayShows extends javax.swing.JPanel {

    private ArrayList<TVShow> Shows;
    private ArrayList<Season> CurrentSeasons;
    private DefaultListModel showModel;
    private DefaultListModel seasonModel;
    private String[] dropdownOpts;
    private final String posterFetchURL = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";
    private TVJSONEditor showReader;
    
    /**
     * Default Constructor
     */
    public DisplayShows() {
        initComponents();
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param importShows
     * @param showReader
     */
    //public DisplayShows(ArrayList<TVShow> importShows, TVJSONEditor showReader) {
    public DisplayShows(TVJSONEditor showReader) {
        initComponents();
        this.showReader = new TVJSONEditor();
        this.showReader = showReader;
        //this.Shows = importShows;
        this.Shows = showReader.getAllShows();
        this.CurrentSeasons = new ArrayList();
        
        // Create show list model
        showModel = new DefaultListModel<String>();
        for(TVShow s : Shows) {
            showModel.addElement(s.getTitle());
        }
        showList.setModel(showModel);
        showList.setSelectedIndex(0);      // Automatically select first item in list
        
    }
    
    
    /**
     * Display all show information in the respective JLabels
     * 
     * @param currentShow 
     */
    private void displayShowInfo(TVShow currentShow) {
        
        // Initialize fields with show data
        showInterested.setSelected(currentShow.getInterested());
        showWatched.setSelected(currentShow.getViewed());
        showTagline.setText(currentShow.getTagline());
        showDesc.setText(currentShow.getDescription());
        showDesc.setEditable(false);
        showDesc.setLineWrap(true);
        showDesc.setWrapStyleWord(true);
        showGenre.setText(currentShow.getGenre());
        showRDate.setText(currentShow.getOriginalRDateString());
        showTitle.setText(currentShow.getTitle());
        
        if(currentShow.getNumSeasons() > 1)
            showNumSeasons.setText(Integer.toString(currentShow.getNumSeasons()) + " Seasons");
        else
            showNumSeasons.setText(Integer.toString(currentShow.getNumSeasons()) + " Season");
        
        
        // Setup show poster
        try {
            String showURL = posterFetchURL + currentShow.getArt();
            URL imageURL = new URL(showURL);
            InputStream in = imageURL.openStream();
            Image image = ImageIO.read(in);
            
            int height = (int) showArt.getSize().getHeight();
            int width = (int) showArt.getSize().getHeight();
            image = image.getScaledInstance(200, 300, Image.SCALE_DEFAULT);
            
            showArt.setIcon(new ImageIcon(image));
        }
        catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        
        // Reset pre-existing Combobox values and JPanel cards
        seasonsDropdown.removeAllItems();
        displaySeasonInfo.removeAll();
        
        // Create season combobox
        displaySeasonInfo.setLayout(new CardLayout());
        seasonsDropdown.setEditable(false);
        displaySeasonInfo(currentShow);
    }
    
    /**
     * Setup displaySeasonInfo JPanel with currently selected season data
     * 
     * @param currentShow 
     */
    private void displaySeasonInfo(TVShow currentShow) {

        // Get all seasons of current show
        CurrentSeasons = currentShow.getSeasons();
        ArrayList<String> seasonTitles = new ArrayList();
        for(Season s : CurrentSeasons)
            seasonTitles.add(s.getSeasonTitle());
        
        // Make dropdown season titles
        dropdownOpts = new String[0];
        dropdownOpts = new String[seasonTitles.size()];
        dropdownOpts = seasonTitles.toArray(dropdownOpts);
        
        for(int idx = 0; idx < dropdownOpts.length; idx++) {
            seasonsDropdown.addItem(dropdownOpts[idx]);
            displaySeasonInfo.add(new DisplaySeasons((CurrentSeasons.get(idx)), this), dropdownOpts[idx]);
        }
    }
    
    /**
     * Update current show object
     * 
     * @param currentShow 
     */
    private void updateShowObject(TVShow currentShow) {
        // Update show object in JSON file
        try {
            showReader.updateShow(currentShow);
        }
        catch (Exception e) {
            System.out.println("Uncaught Exeption - Did not update object");
        }
    }
    
    /**
     * Update currently selected season object and update current show object
     * 
     * @param importSeason 
     */
    public void updateSeasonObject(Season importSeason) {
        
        // Get current show
        TVShow currentShow = new TVShow();
        currentShow = Shows.get(showList.getSelectedIndex());
        
        // Create new Seasons Array for update
        ArrayList<Season> newSeasons = new ArrayList();
        
        // Locate matching season ID
        for(Season s: currentShow.getSeasons()) {
            if(s.getSeasonID() == importSeason.getSeasonID())   // Matching ID, add updated season object
                newSeasons.add(importSeason);
            else                                                // Add existing season object
                newSeasons.add(s);
        }
        
        // Update current show Seasons ArrayList
        currentShow.setSeasons(newSeasons);
        
        // Update current show object
        updateShowObject(currentShow);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showListContainer = new javax.swing.JPanel();
        showListScroll = new javax.swing.JScrollPane();
        showList = new javax.swing.JList<>();
        displayShowInfoContainer = new javax.swing.JPanel();
        displayShowStatus = new javax.swing.JPanel();
        showArt = new javax.swing.JLabel();
        showInterested = new javax.swing.JCheckBox();
        showWatched = new javax.swing.JCheckBox();
        displayShowInfo = new javax.swing.JPanel();
        showTitle = new javax.swing.JLabel();
        showRDate = new javax.swing.JLabel();
        showNumSeasons = new javax.swing.JLabel();
        showGenre = new javax.swing.JLabel();
        showTagline = new javax.swing.JLabel();
        showDescScroll = new javax.swing.JScrollPane();
        showDesc = new javax.swing.JTextArea();
        seasonsDropdownContainer = new javax.swing.JPanel();
        seasonsDropdown = new javax.swing.JComboBox<>();
        displaySeasonInfo = new javax.swing.JPanel();

        setLayout(null);

        showList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        showList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                showListValueChanged(evt);
            }
        });
        showListScroll.setViewportView(showList);

        javax.swing.GroupLayout showListContainerLayout = new javax.swing.GroupLayout(showListContainer);
        showListContainer.setLayout(showListContainerLayout);
        showListContainerLayout.setHorizontalGroup(
            showListContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showListContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );
        showListContainerLayout.setVerticalGroup(
            showListContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showListContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(showListContainer);
        showListContainer.setBounds(6, 6, 152, 492);

        showInterested.setText("Interested in this show?");
        showInterested.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInterestedActionPerformed(evt);
            }
        });

        showWatched.setText("Watched this entire show?");
        showWatched.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showWatchedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displayShowStatusLayout = new javax.swing.GroupLayout(displayShowStatus);
        displayShowStatus.setLayout(displayShowStatusLayout);
        displayShowStatusLayout.setHorizontalGroup(
            displayShowStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayShowStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayShowStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displayShowStatusLayout.createSequentialGroup()
                        .addComponent(showArt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(showWatched, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showInterested, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        displayShowStatusLayout.setVerticalGroup(
            displayShowStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayShowStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showArt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showInterested)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showWatched)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        displayShowInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showTitle.setText("Title");
        displayShowInfo.add(showTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 228, 48));

        showRDate.setText("Release Date");
        displayShowInfo.add(showRDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 60, 228, 23));

        showNumSeasons.setText("Seasons");
        displayShowInfo.add(showNumSeasons, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 89, 86, 23));

        showGenre.setText("Genre");
        displayShowInfo.add(showGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 89, 136, 23));

        showTagline.setText("Tagline");
        displayShowInfo.add(showTagline, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 130, 228, 23));

        showDesc.setColumns(20);
        showDesc.setRows(5);
        showDescScroll.setViewportView(showDesc);

        displayShowInfo.add(showDescScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 206, 228, 274));

        seasonsDropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                seasonsDropdownItemStateChanged(evt);
            }
        });
        seasonsDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seasonsDropdownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout seasonsDropdownContainerLayout = new javax.swing.GroupLayout(seasonsDropdownContainer);
        seasonsDropdownContainer.setLayout(seasonsDropdownContainerLayout);
        seasonsDropdownContainerLayout.setHorizontalGroup(
            seasonsDropdownContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(seasonsDropdown, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        seasonsDropdownContainerLayout.setVerticalGroup(
            seasonsDropdownContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seasonsDropdownContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seasonsDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        displayShowInfo.add(seasonsDropdownContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 159, 228, -1));

        javax.swing.GroupLayout displaySeasonInfoLayout = new javax.swing.GroupLayout(displaySeasonInfo);
        displaySeasonInfo.setLayout(displaySeasonInfoLayout);
        displaySeasonInfoLayout.setHorizontalGroup(
            displaySeasonInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );
        displaySeasonInfoLayout.setVerticalGroup(
            displaySeasonInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout displayShowInfoContainerLayout = new javax.swing.GroupLayout(displayShowInfoContainer);
        displayShowInfoContainer.setLayout(displayShowInfoContainerLayout);
        displayShowInfoContainerLayout.setHorizontalGroup(
            displayShowInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayShowInfoContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayShowStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayShowInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displaySeasonInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        displayShowInfoContainerLayout.setVerticalGroup(
            displayShowInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, displayShowInfoContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayShowInfoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(displaySeasonInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayShowStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayShowInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(displayShowInfoContainer);
        displayShowInfoContainer.setBounds(164, 6, 690, 492);
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Update display of show information based on selected show in list
     * 
     * @param evt 
     */
    private void showListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_showListValueChanged
        TVShow currentShow = new TVShow();
        currentShow = Shows.get(showList.getSelectedIndex());
        displayShowInfo(currentShow);
    }//GEN-LAST:event_showListValueChanged

    /**
     * Update show interest status for current show
     * 
     * @param evt 
     */
    private void showInterestedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInterestedActionPerformed
        // Get show object
        TVShow currentShow = Shows.get(showList.getSelectedIndex());
        
        // Set show interest status
        if(showInterested.isSelected())
            currentShow.setInterested(true);
        else
            currentShow.setInterested(false);
        
        // Update show object
        updateShowObject(currentShow);
        
        // Re-display show info
        displayShowInfo(currentShow);
    }//GEN-LAST:event_showInterestedActionPerformed

    /**
     * Update show watched status for current show
     * 
     * @param evt 
     */
    private void showWatchedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showWatchedActionPerformed
        // Get show object
        TVShow currentShow = Shows.get(showList.getSelectedIndex());
        
        // Set show watched status
        if(showWatched.isSelected())
            currentShow.setViewed(true);
        else
            currentShow.setViewed(false);
        
        // Update show object
        updateShowObject(currentShow);
        
        // Re-display show info
        displayShowInfo(currentShow);
    }//GEN-LAST:event_showWatchedActionPerformed

    private void seasonsDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seasonsDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seasonsDropdownActionPerformed

    private void seasonsDropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_seasonsDropdownItemStateChanged
        CardLayout cl = (CardLayout)(displaySeasonInfo.getLayout());
        cl.show(displaySeasonInfo, (String)evt.getItem());
    }//GEN-LAST:event_seasonsDropdownItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel displaySeasonInfo;
    private javax.swing.JPanel displayShowInfo;
    private javax.swing.JPanel displayShowInfoContainer;
    private javax.swing.JPanel displayShowStatus;
    private javax.swing.JComboBox<String> seasonsDropdown;
    private javax.swing.JPanel seasonsDropdownContainer;
    private javax.swing.JLabel showArt;
    private javax.swing.JTextArea showDesc;
    private javax.swing.JScrollPane showDescScroll;
    private javax.swing.JLabel showGenre;
    private javax.swing.JCheckBox showInterested;
    private javax.swing.JList<String> showList;
    private javax.swing.JPanel showListContainer;
    private javax.swing.JScrollPane showListScroll;
    private javax.swing.JLabel showNumSeasons;
    private javax.swing.JLabel showRDate;
    private javax.swing.JLabel showTagline;
    private javax.swing.JLabel showTitle;
    private javax.swing.JCheckBox showWatched;
    // End of variables declaration//GEN-END:variables
}
