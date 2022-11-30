package home;

import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnsceneGUI extends javax.swing.JFrame {

    // Static Displays
    public static DisplayHome home;                                 // Home page JPanel
    public static DisplayMovies discoverMovies, watchlistMovies;    // Movie JPanels
    public static DisplayShows discoverShows, watchlistShows;       // TVShow JPanels
    public static DisplayOptions options;                           // Options JPanel
    // Movie & show assets
    private static MovieJSONEditor movieReader;     // MovieJSONEditor to read movie data file
    private static TVJSONEditor showReader;         // TVJSONEditor to read TV data file
    // User assets
    private static String UserName;                 // User's profile name
    
    
    /**
     * Default Constructor
     */
    public UnsceneGUI() {
        initComponents();
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param movieReader to read movie data file
     * @param showReader to read show data file
     * @param UserName profile name
     * @throws Exception 
     */
    public UnsceneGUI(MovieJSONEditor movieReader, TVJSONEditor showReader, String UserName) throws Exception {
        initComponents();
        
        setTitle("Unscene");
        this.movieReader = new MovieJSONEditor();
        this.movieReader = movieReader;
        this.showReader = new TVJSONEditor();
        this.showReader = showReader;
        
        this.UserName = UserName;
        
        configureDisplays();
    }
    
    
    /**
     * Setup JPanels for display
     * 
     * @throws Exception 
     */
    public static void configureDisplays() throws Exception {
        configureHomePage();
        configureDiscoverPage();
        configureWatchlistPage();
        configureOptionsPage();
    }
    
    /**
     * Remove, repaint, and revalidate all JPanels
     */
    public static void removeDisplays() {
        DiscoverMovie.removeAll();
        DiscoverMovie.repaint();
        DiscoverMovie.revalidate();
        
        DiscoverShow.removeAll();
        DiscoverShow.repaint();
        DiscoverShow.revalidate();
        
        WatchlistMovie.removeAll();
        WatchlistMovie.repaint();
        WatchlistMovie.revalidate();
        
        WatchlistShow.removeAll();
        WatchlistShow.repaint();
        WatchlistShow.revalidate();
        
        HomeContainer.removeAll();
        HomeContainer.repaint();
        HomeContainer.revalidate();
        
        OptionsContainer.removeAll();
        OptionsContainer.repaint();
        OptionsContainer.revalidate();
    }
    
    /**
     * Setup home JPanel
     */
    public static void configureHomePage() {
        home = new DisplayHome(UserName, movieReader, showReader);
        HomeContainer.setLayout(new BorderLayout());
        HomeContainer.add(home);
        HomeContainer.updateUI();
    }
    
    /**
     * Setup Discover JPanels
     */
    public static void configureDiscoverPage() {
        // Configure Movies
        DisplayMovies discoverMovies = new DisplayMovies(movieReader, true);
        DiscoverMovie.setLayout(new BorderLayout());
        DiscoverMovie.add(discoverMovies);
        DiscoverMovie.updateUI();
        
        // Configure Shows
        DisplayShows discoverShows = new DisplayShows(showReader, true);
        DiscoverShow.setLayout(new BorderLayout());
        DiscoverShow.add(discoverShows);
        DiscoverShow.updateUI();
    }
    
    /**
     * Setup Watch list JPanels
     */
    public static void configureWatchlistPage() {
        // Configure Movies
        DisplayMovies watchlistMovies = new DisplayMovies(movieReader, false);
        WatchlistMovie.setLayout(new BorderLayout());
        WatchlistMovie.add(watchlistMovies);
        WatchlistMovie.updateUI();
        
        // Configure Shows
        DisplayShows watchlistShows = new DisplayShows(showReader, false);
        WatchlistShow.setLayout(new BorderLayout());
        WatchlistShow.add(watchlistShows);
        WatchlistShow.updateUI();
    }
    
    /**
     * Setup options JPanel
     */
    public static void configureOptionsPage() throws Exception {
        DisplayOptions options = new DisplayOptions("src/data/settings.json");
        OptionsContainer.setLayout(new BorderLayout());
        OptionsContainer.add(options);
        OptionsContainer.updateUI();
    }
    
    
    /**
     * Refresh GUI to display update movie and TV show data
     */
    public static void refreshGUI() {
        try {
            removeDisplays();
            configureDisplays();
        } catch (Exception ex) {
            Logger.getLogger(UnsceneGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UnscenePages = new javax.swing.JTabbedPane();
        HomePage = new javax.swing.JPanel();
        HomeContainer = new javax.swing.JPanel();
        DiscoverPage = new javax.swing.JPanel();
        DiscoverContainer = new javax.swing.JTabbedPane();
        DiscoverMovie = new javax.swing.JPanel();
        DiscoverShow = new javax.swing.JPanel();
        WatchlistPage = new javax.swing.JPanel();
        WatchlistContainer = new javax.swing.JTabbedPane();
        WatchlistMovie = new javax.swing.JPanel();
        WatchlistShow = new javax.swing.JPanel();
        OptionsPage = new javax.swing.JPanel();
        OptionsContainer = new javax.swing.JPanel();
        UnsceneHeader = new javax.swing.JPanel();
        UnsceneTitle = new javax.swing.JLabel();
        UnsceneLogo = new javax.swing.JLabel();
        UnsceneRefresh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1001, 620));

        UnscenePages.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        UnscenePages.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                UnscenePagesStateChanged(evt);
            }
        });

        HomePage.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout HomeContainerLayout = new javax.swing.GroupLayout(HomeContainer);
        HomeContainer.setLayout(HomeContainerLayout);
        HomeContainerLayout.setHorizontalGroup(
            HomeContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
        );
        HomeContainerLayout.setVerticalGroup(
            HomeContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        HomePage.add(HomeContainer, java.awt.BorderLayout.CENTER);

        UnscenePages.addTab("Home", HomePage);

        DiscoverPage.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout DiscoverMovieLayout = new javax.swing.GroupLayout(DiscoverMovie);
        DiscoverMovie.setLayout(DiscoverMovieLayout);
        DiscoverMovieLayout.setHorizontalGroup(
            DiscoverMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
        );
        DiscoverMovieLayout.setVerticalGroup(
            DiscoverMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        DiscoverContainer.addTab("Movies", DiscoverMovie);

        javax.swing.GroupLayout DiscoverShowLayout = new javax.swing.GroupLayout(DiscoverShow);
        DiscoverShow.setLayout(DiscoverShowLayout);
        DiscoverShowLayout.setHorizontalGroup(
            DiscoverShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
        );
        DiscoverShowLayout.setVerticalGroup(
            DiscoverShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        DiscoverContainer.addTab("TV Shows", DiscoverShow);

        DiscoverPage.add(DiscoverContainer, java.awt.BorderLayout.CENTER);

        UnscenePages.addTab("Discover", DiscoverPage);

        javax.swing.GroupLayout WatchlistMovieLayout = new javax.swing.GroupLayout(WatchlistMovie);
        WatchlistMovie.setLayout(WatchlistMovieLayout);
        WatchlistMovieLayout.setHorizontalGroup(
            WatchlistMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
        );
        WatchlistMovieLayout.setVerticalGroup(
            WatchlistMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        WatchlistContainer.addTab("Movies", WatchlistMovie);

        javax.swing.GroupLayout WatchlistShowLayout = new javax.swing.GroupLayout(WatchlistShow);
        WatchlistShow.setLayout(WatchlistShowLayout);
        WatchlistShowLayout.setHorizontalGroup(
            WatchlistShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
        );
        WatchlistShowLayout.setVerticalGroup(
            WatchlistShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        WatchlistContainer.addTab("TV Shows", WatchlistShow);

        javax.swing.GroupLayout WatchlistPageLayout = new javax.swing.GroupLayout(WatchlistPage);
        WatchlistPage.setLayout(WatchlistPageLayout);
        WatchlistPageLayout.setHorizontalGroup(
            WatchlistPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
            .addGroup(WatchlistPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(WatchlistPageLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(WatchlistContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        WatchlistPageLayout.setVerticalGroup(
            WatchlistPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
            .addGroup(WatchlistPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(WatchlistPageLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(WatchlistContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        UnscenePages.addTab("Watchlist", WatchlistPage);

        OptionsPage.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout OptionsContainerLayout = new javax.swing.GroupLayout(OptionsContainer);
        OptionsContainer.setLayout(OptionsContainerLayout);
        OptionsContainerLayout.setHorizontalGroup(
            OptionsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
        );
        OptionsContainerLayout.setVerticalGroup(
            OptionsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        OptionsPage.add(OptionsContainer, java.awt.BorderLayout.CENTER);

        UnscenePages.addTab("Options", OptionsPage);

        getContentPane().add(UnscenePages, java.awt.BorderLayout.CENTER);

        UnsceneTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        UnsceneTitle.setText("UNSCENE");

        UnsceneLogo.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        UnsceneLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/unscene_icon.png"))); // NOI18N
        UnsceneLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UnsceneLogoMouseClicked(evt);
            }
        });

        UnsceneRefresh.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        UnsceneRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refresh.png"))); // NOI18N
        UnsceneRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UnsceneRefreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout UnsceneHeaderLayout = new javax.swing.GroupLayout(UnsceneHeader);
        UnsceneHeader.setLayout(UnsceneHeaderLayout);
        UnsceneHeaderLayout.setHorizontalGroup(
            UnsceneHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UnsceneHeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(UnsceneLogo)
                .addGap(18, 18, 18)
                .addComponent(UnsceneTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(UnsceneRefresh)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        UnsceneHeaderLayout.setVerticalGroup(
            UnsceneHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UnsceneHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UnsceneHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UnsceneRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(UnsceneLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(UnsceneTitle, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        getContentPane().add(UnsceneHeader, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UnsceneLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnsceneLogoMouseClicked
        
    }//GEN-LAST:event_UnsceneLogoMouseClicked

    /**
     * If refresh button is pressed, update all of UnsceneGUI
     * @param evt 
     */
    private void UnsceneRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnsceneRefreshMouseClicked
        refreshGUI();
    }//GEN-LAST:event_UnsceneRefreshMouseClicked

    /**
     * Refresh GUI with every change in tab
     * @param evt 
     */
    private void UnscenePagesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_UnscenePagesStateChanged
        refreshGUI();
    }//GEN-LAST:event_UnscenePagesStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnsceneGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane DiscoverContainer;
    public static javax.swing.JPanel DiscoverMovie;
    private javax.swing.JPanel DiscoverPage;
    public static javax.swing.JPanel DiscoverShow;
    public static javax.swing.JPanel HomeContainer;
    private javax.swing.JPanel HomePage;
    public static javax.swing.JPanel OptionsContainer;
    private javax.swing.JPanel OptionsPage;
    private javax.swing.JPanel UnsceneHeader;
    private javax.swing.JLabel UnsceneLogo;
    private javax.swing.JTabbedPane UnscenePages;
    private javax.swing.JLabel UnsceneRefresh;
    private javax.swing.JLabel UnsceneTitle;
    private javax.swing.JTabbedPane WatchlistContainer;
    public static javax.swing.JPanel WatchlistMovie;
    private javax.swing.JPanel WatchlistPage;
    public static javax.swing.JPanel WatchlistShow;
    // End of variables declaration//GEN-END:variables
}
