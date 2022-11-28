package home;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.io.InputStream;

import javax.swing.JScrollPane;

public class UnsceneGUI extends javax.swing.JFrame {

    // Movie assets
    private MovieJSONEditor movieReader;
    private TVJSONEditor showReader;
    //private ArrayList<Movie> Movies;
    //private ArrayList<TVShow> Shows;
    
    
    public UnsceneGUI() {
        initComponents();
    }
    
    /**
     * Overloaded Constructor
     * 
     * @param movieReader
     * @param showReader 
     */
    public UnsceneGUI(MovieJSONEditor movieReader, TVJSONEditor showReader) {
        initComponents();
        
        setTitle("Unscene");
        this.movieReader = new MovieJSONEditor();
        this.movieReader = movieReader;
        this.showReader = new TVJSONEditor();
        this.showReader = showReader;
        
        //this.Movies = new ArrayList(movieReader.getAllMovies());
        //this.Shows = new ArrayList(showReader.getAllShows());
        
        configureDiscoverPage();
    }
    
    
    public void configureDiscoverPage() {
        
        //DisplayMovies discoverMovies = new DisplayMovies(Movies, movieReader);
        DisplayMovies discoverMovies = new DisplayMovies(movieReader);
        DiscoverMovie.setLayout(new BorderLayout());
        DiscoverMovie.add(discoverMovies);
        DiscoverMovie.updateUI();
        
        //DisplayShows discoverShows = new DisplayShows(Shows, showReader);
        DisplayShows discoverShows = new DisplayShows(showReader);
        DiscoverShow.setLayout(new BorderLayout());
        DiscoverShow.add(discoverShows);
        DiscoverShow.updateUI();
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
        DiscoverPage = new javax.swing.JPanel();
        DiscoverContainer = new javax.swing.JTabbedPane();
        DiscoverMovie = new javax.swing.JPanel();
        DiscoverShow = new javax.swing.JPanel();
        WatchlistPage = new javax.swing.JPanel();
        WatchlistContainer = new javax.swing.JTabbedPane();
        WatchlistMovie = new javax.swing.JPanel();
        WatchlistShow = new javax.swing.JPanel();
        OptionsPage = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UnscenePages.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout DiscoverMovieLayout = new javax.swing.GroupLayout(DiscoverMovie);
        DiscoverMovie.setLayout(DiscoverMovieLayout);
        DiscoverMovieLayout.setHorizontalGroup(
            DiscoverMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        DiscoverMovieLayout.setVerticalGroup(
            DiscoverMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );

        DiscoverContainer.addTab("Movies", DiscoverMovie);

        javax.swing.GroupLayout DiscoverShowLayout = new javax.swing.GroupLayout(DiscoverShow);
        DiscoverShow.setLayout(DiscoverShowLayout);
        DiscoverShowLayout.setHorizontalGroup(
            DiscoverShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        DiscoverShowLayout.setVerticalGroup(
            DiscoverShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );

        DiscoverContainer.addTab("TV Shows", DiscoverShow);

        javax.swing.GroupLayout DiscoverPageLayout = new javax.swing.GroupLayout(DiscoverPage);
        DiscoverPage.setLayout(DiscoverPageLayout);
        DiscoverPageLayout.setHorizontalGroup(
            DiscoverPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DiscoverPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DiscoverContainer)
                .addContainerGap())
        );
        DiscoverPageLayout.setVerticalGroup(
            DiscoverPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DiscoverPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DiscoverContainer)
                .addContainerGap())
        );

        UnscenePages.addTab("Discover", DiscoverPage);

        javax.swing.GroupLayout WatchlistMovieLayout = new javax.swing.GroupLayout(WatchlistMovie);
        WatchlistMovie.setLayout(WatchlistMovieLayout);
        WatchlistMovieLayout.setHorizontalGroup(
            WatchlistMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        WatchlistMovieLayout.setVerticalGroup(
            WatchlistMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        WatchlistContainer.addTab("Movies", WatchlistMovie);

        javax.swing.GroupLayout WatchlistShowLayout = new javax.swing.GroupLayout(WatchlistShow);
        WatchlistShow.setLayout(WatchlistShowLayout);
        WatchlistShowLayout.setHorizontalGroup(
            WatchlistShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        WatchlistShowLayout.setVerticalGroup(
            WatchlistShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        WatchlistContainer.addTab("TV Shows", WatchlistShow);

        javax.swing.GroupLayout WatchlistPageLayout = new javax.swing.GroupLayout(WatchlistPage);
        WatchlistPage.setLayout(WatchlistPageLayout);
        WatchlistPageLayout.setHorizontalGroup(
            WatchlistPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WatchlistPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WatchlistContainer)
                .addContainerGap())
        );
        WatchlistPageLayout.setVerticalGroup(
            WatchlistPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WatchlistPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WatchlistContainer)
                .addContainerGap())
        );

        UnscenePages.addTab("Watchlist", WatchlistPage);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout OptionsPageLayout = new javax.swing.GroupLayout(OptionsPage);
        OptionsPage.setLayout(OptionsPageLayout);
        OptionsPageLayout.setHorizontalGroup(
            OptionsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionsPageLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        OptionsPageLayout.setVerticalGroup(
            OptionsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionsPageLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        UnscenePages.addTab("Options", OptionsPage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UnscenePages)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(UnscenePages)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel DiscoverMovie;
    private javax.swing.JPanel DiscoverPage;
    private javax.swing.JPanel DiscoverShow;
    private javax.swing.JPanel OptionsPage;
    private javax.swing.JTabbedPane UnscenePages;
    private javax.swing.JTabbedPane WatchlistContainer;
    private javax.swing.JPanel WatchlistMovie;
    private javax.swing.JPanel WatchlistPage;
    private javax.swing.JPanel WatchlistShow;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
