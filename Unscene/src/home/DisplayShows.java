
package home;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class DisplayShows extends javax.swing.JPanel {
    private ArrayList<TVShow> Shows;            // List of shows (either All or Interested)    
    private ArrayList<Season> Seasons;          // List of seasons for current show object being displayed
    private TVShow CurrentShow;                 // Current show object being displayed
    private Season CurrentSeason;               // Current season being displayed
    private DefaultListModel showModel;         // Model for list of shows
    private DefaultListModel seasonModel;       // Model for dropdown of seasons
    private final String posterFetchURL;        // URL prefix for TV show posters
    private TVJSONEditor showReader;            // TVJSONEditor to read TV show data file
    private final boolean selectListAll;        // Boolean: T for AllShows, F for InterestedShows
    
    
    /**
     * Default Constructor
     */
    public DisplayShows() {
        initComponents();
        posterFetchURL = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";
        selectListAll = false;
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param showReader to read TV show data file
     * @param All Boolean - (T = Get All Shows) (F = Get Interested Shows)
     */
    public DisplayShows(TVJSONEditor showReader, boolean All) {
        initComponents();
        posterFetchURL = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";
        // Initialize fields
        this.showReader = new TVJSONEditor();
        this.showReader = showReader;
        this.selectListAll = All;
        
        // Get correct list based on "All" parameter
        this.Shows = getShowList();
        this.Seasons = new ArrayList();
        
        seasonsDropdown.removeAllItems();
        
        // Create show list model
        showModel = new DefaultListModel<String>();
        for(TVShow s : Shows) {
            showModel.addElement(s.getTitle());
        }
        showList.setModel(showModel);
        showList.setSelectedIndex(0);       // Automatically select first item in list
    }
    
    
    /**
     * Get specified TV show list: all shows or interested shows
     * 
     * @return Specified show list
     */
    private ArrayList<TVShow> getShowList() {
        if(selectListAll)
            return showReader.getAllShows();
        else
            return showReader.getInterestedShows();
    }
    
    
    /**
     * Setup UI for JPanel
     */
    private void displayShowInfo() {
        
        // Initialize labels with show data
        showInterested.setSelected(CurrentShow.getInterested());
        showWatched.setSelected(CurrentShow.getViewed());
        showTagline.setText(CurrentShow.getTagline());
        showDesc.setText(CurrentShow.getDescription());
        showDesc.setEditable(false);
        showDesc.setLineWrap(true);
        showDesc.setWrapStyleWord(true);
        showGenre.setText(CurrentShow.getGenre());
        showOriginalRDate.setText(CurrentShow.getOriginalRDateString());
        showTitle.setText(CurrentShow.getTitle());
        
        // Set number of seasons total
        if(CurrentShow.getNumSeasons() > 1)
            showNumSeasons.setText(Integer.toString(CurrentShow.getNumSeasons()) + " Seasons");
        else
            showNumSeasons.setText(Integer.toString(CurrentShow.getNumSeasons()) + " Season");
        
        // Setup show poster
        try {
            String showURL = posterFetchURL + CurrentShow.getArt();
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
        
        
        // Reset pre-existing Combobox values
        seasonsDropdown.removeAllItems();
        
        // Get all seasons of current show
        Seasons = CurrentShow.getSeasons();
        ArrayList<String> seasonTitles = new ArrayList();
        for(Season s : Seasons){
            seasonTitles.add(s.getSeasonTitle());
        }
        
        // Make dropdown season titles
        String[] dropdownOpts = new String[0];
        dropdownOpts = new String[seasonTitles.size()];
        dropdownOpts = seasonTitles.toArray(dropdownOpts);
        
        
        // Insert seasons titles to combo box
        for(int optIdx = 0; optIdx < dropdownOpts.length; optIdx++) {
            seasonsDropdown.insertItemAt(dropdownOpts[optIdx], optIdx);
        }
        
        seasonsDropdown.setEditable(false);
        seasonsDropdown.setSelectedIndex(0);
    }
    
    /**
     * Setup displaySeasonInfo JPanel with currently selected season data
     */
    private void displaySeasonInfo() {
        
        // Initialize fields with show data
        seasonDesc.setText(CurrentSeason.getSeasonDesc());
        seasonDesc.setEditable(false);
        seasonDesc.setLineWrap(true);
        seasonDesc.setWrapStyleWord(true);
        seasonRDate.setText(CurrentSeason.getRDateString());
        seasonTitle.setText(CurrentSeason.getSeasonTitle());
        seasonWatched.setSelected(CurrentSeason.getSeasonWatched());
        
        // Initialize total number of episodes
        if(CurrentSeason.getEpTotal() > 1)
            seasonEpT.setText(Integer.toString(CurrentSeason.getEpTotal()) + " Episodes");
        else
            seasonEpT.setText(Integer.toString(CurrentSeason.getEpTotal()) + " Episode");
    }
    
    /**
     * Update current show object
     */
    private void updateShowObject() {
        CurrentShow.updateSeasonsWatched();
        
        // Update show object in JSON file
        try {
            showReader.updateShow(CurrentShow);
        }
        catch (Exception e) {
            System.out.println("Uncaught Exeption - Did not update object");
        }
        
        displayShowInfo();
    }
    
    /**
     * Update currently selected season object and update current show object
     */
    public void updateSeasonObject() {
        
        // Create new Seasons Array for update
        ArrayList<Season> newSeasonsList = new ArrayList();
        
        // Locate matching season ID
        for(Season s: Seasons) {
            if(s.getSeasonID() == CurrentSeason.getSeasonID()) {                    // Matching ID, add updated season object
                s.setSeasonWatched(seasonWatched.isSelected());
            }
            newSeasonsList.add(s);
        }
        
        // Update current show Seasons ArrayList
        CurrentShow.setSeasons(newSeasonsList);
        Seasons = newSeasonsList;
        
        // Update current show object
        updateShowObject();
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
        showFullContainer = new javax.swing.JPanel();
        displayShowStatus = new javax.swing.JPanel();
        showArt = new javax.swing.JLabel();
        showInterested = new javax.swing.JCheckBox();
        showWatched = new javax.swing.JCheckBox();
        displayShowInfo = new javax.swing.JPanel();
        showTitle = new javax.swing.JLabel();
        showOriginalRDate = new javax.swing.JLabel();
        showNumSeasons = new javax.swing.JLabel();
        showDescScroll = new javax.swing.JScrollPane();
        showDesc = new javax.swing.JTextArea();
        seasonsDropdownContainer = new javax.swing.JPanel();
        seasonsDropdown = new javax.swing.JComboBox<>();
        showGenre = new javax.swing.JLabel();
        showTagline = new javax.swing.JLabel();
        displaySeasonInfo = new javax.swing.JPanel();
        seasonEpT = new javax.swing.JLabel();
        seasonRDate = new javax.swing.JLabel();
        seasonTitle = new javax.swing.JLabel();
        seasonWatched = new javax.swing.JCheckBox();
        seasonDescScroll = new javax.swing.JScrollPane();
        seasonDesc = new javax.swing.JTextArea();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showList.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
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
                .addComponent(showListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
        showListContainerLayout.setVerticalGroup(
            showListContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showListContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(showListContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        showFullContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        displayShowStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        displayShowStatus.add(showArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 200, 300));

        showInterested.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        showInterested.setText("Interested in this show?");
        showInterested.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInterestedActionPerformed(evt);
            }
        });
        displayShowStatus.add(showInterested, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 318, 200, -1));

        showWatched.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        showWatched.setText("Watched this show?");
        showWatched.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showWatchedActionPerformed(evt);
            }
        });
        displayShowStatus.add(showWatched, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 345, 200, -1));

        showFullContainer.add(displayShowStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        displayShowInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 21)); // NOI18N
        showTitle.setText("There are no shows in this list.");
        displayShowInfo.add(showTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 310, 48));

        showOriginalRDate.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        displayShowInfo.add(showOriginalRDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 60, 310, 23));

        showNumSeasons.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        displayShowInfo.add(showNumSeasons, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 89, 310, 23));

        showDesc.setColumns(20);
        showDesc.setRows(5);
        showDescScroll.setViewportView(showDesc);

        displayShowInfo.add(showDescScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 286, 310, 206));

        seasonsDropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                seasonsDropdownItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout seasonsDropdownContainerLayout = new javax.swing.GroupLayout(seasonsDropdownContainer);
        seasonsDropdownContainer.setLayout(seasonsDropdownContainerLayout);
        seasonsDropdownContainerLayout.setHorizontalGroup(
            seasonsDropdownContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
            .addGroup(seasonsDropdownContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seasonsDropdownContainerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(seasonsDropdown, 0, 310, Short.MAX_VALUE)))
        );
        seasonsDropdownContainerLayout.setVerticalGroup(
            seasonsDropdownContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
            .addGroup(seasonsDropdownContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(seasonsDropdownContainerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(seasonsDropdown, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        displayShowInfo.add(seasonsDropdownContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, -1, -1));

        showGenre.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        showGenre.setMaximumSize(new java.awt.Dimension(310, 29));
        displayShowInfo.add(showGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 118, 310, 29));

        showTagline.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        displayShowInfo.add(showTagline, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 187, 310, 30));

        showFullContainer.add(displayShowInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 6, -1, -1));

        displaySeasonInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seasonEpT.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        displaySeasonInfo.add(seasonEpT, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 89, 255, 27));

        seasonRDate.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        displaySeasonInfo.add(seasonRDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 60, 255, 23));

        seasonTitle.setFont(new java.awt.Font("Helvetica Neue", 2, 18)); // NOI18N
        displaySeasonInfo.add(seasonTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 255, 48));

        seasonWatched.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        seasonWatched.setText("Watched this season?");
        seasonWatched.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seasonWatchedActionPerformed(evt);
            }
        });
        displaySeasonInfo.add(seasonWatched, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 134, 255, -1));

        seasonDesc.setColumns(20);
        seasonDesc.setRows(5);
        seasonDescScroll.setViewportView(seasonDesc);

        displaySeasonInfo.add(seasonDescScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 173, 259, 319));

        showFullContainer.add(displaySeasonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 6, -1, -1));

        add(showFullContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 6, 820, -1));
    }// </editor-fold>//GEN-END:initComponents

    
    
    /**
     * Update display of show information based on selected show in list
     * @param evt 
     */
    private void showListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_showListValueChanged
        CurrentShow = Shows.get(showList.getSelectedIndex());
        displayShowInfo();
    }//GEN-LAST:event_showListValueChanged

    /**
     * Update show interest status for current show
     * @param evt 
     */
    private void showInterestedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInterestedActionPerformed
        // Get currently selected show index
        int currentIdx = showList.getSelectedIndex();

        // Set show interest status
        if(showInterested.isSelected())
            CurrentShow.setInterested(true);
        else
            CurrentShow.setInterested(false);
        
        // Update show object
        updateShowObject();
        
        // If displaying for watchlist AND show was removed
        if(!selectListAll && !showInterested.isSelected())
            UnsceneGUI.refreshGUI();
        else
            showList.setSelectedIndex(currentIdx);
    }//GEN-LAST:event_showInterestedActionPerformed

    /**
     * Update show watched status for current show
     * @param evt 
     */
    private void showWatchedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showWatchedActionPerformed
        // Get currently selected show index
        int currentIdx = showList.getSelectedIndex();

        // Set show watched status
        if(showWatched.isSelected())
            CurrentShow.setViewed(true);
        else
            CurrentShow.setViewed(false);
        
        // Update show object
        updateShowObject();
        
        // If displaying for watchlist AND show was removed
        if(!selectListAll && !showWatched.isSelected())
            UnsceneGUI.refreshGUI();
        else
            showList.setSelectedIndex(currentIdx);
    }//GEN-LAST:event_showWatchedActionPerformed

    /**
     * Update display of season information based on selected season in drop down
     * @param evt 
     */
    private void seasonsDropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_seasonsDropdownItemStateChanged
        if(seasonsDropdown.getSelectedIndex() >= 0) {   // Verify valid index
            CurrentSeason = Seasons.get(seasonsDropdown.getSelectedIndex());
            displaySeasonInfo();
        }
    }//GEN-LAST:event_seasonsDropdownItemStateChanged

    /**
     * Update season watched status for current season
     * @param evt 
     */
    private void seasonWatchedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seasonWatchedActionPerformed
        // Set season interest status
        if(seasonWatched.isSelected())
            CurrentSeason.setSeasonWatched(true);
        else
            CurrentSeason.setSeasonWatched(false);

        // Get current season index
        int currentIdx = seasonsDropdown.getSelectedIndex();

        // Update season object and refresh
        updateSeasonObject();
        
        // Select current season
        seasonsDropdown.setSelectedIndex(currentIdx);
    }//GEN-LAST:event_seasonWatchedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel displaySeasonInfo;
    private javax.swing.JPanel displayShowInfo;
    private javax.swing.JPanel displayShowStatus;
    private javax.swing.JTextArea seasonDesc;
    private javax.swing.JScrollPane seasonDescScroll;
    private javax.swing.JLabel seasonEpT;
    private javax.swing.JLabel seasonRDate;
    private javax.swing.JLabel seasonTitle;
    private javax.swing.JCheckBox seasonWatched;
    private javax.swing.JComboBox<String> seasonsDropdown;
    private javax.swing.JPanel seasonsDropdownContainer;
    private javax.swing.JLabel showArt;
    private javax.swing.JTextArea showDesc;
    private javax.swing.JScrollPane showDescScroll;
    private javax.swing.JPanel showFullContainer;
    private javax.swing.JLabel showGenre;
    private javax.swing.JCheckBox showInterested;
    private javax.swing.JList<String> showList;
    private javax.swing.JPanel showListContainer;
    private javax.swing.JScrollPane showListScroll;
    private javax.swing.JLabel showNumSeasons;
    private javax.swing.JLabel showOriginalRDate;
    private javax.swing.JLabel showTagline;
    private javax.swing.JLabel showTitle;
    private javax.swing.JCheckBox showWatched;
    // End of variables declaration//GEN-END:variables
}
