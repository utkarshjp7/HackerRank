import java.util.*;

enum FolderType {
    SHARED, CONF
}

public class CowsAndFolders {

    public static void main(String args[]) {

        Scanner sn = new Scanner(System.in);
        
        int numOfCows = sn.nextInt();;
        int numOfSharedFolders = sn.nextInt();;
        int numOfConfidentialFolders = sn.nextInt();;

        Forest folderForest = new Forest();

        for (int i=0; i<numOfSharedFolders; i++) {
            int folderId = sn.nextInt();
            Folder folder = new Folder(folderId, FolderType.SHARED);                        
            int numOfAuthCows = sn.nextInt();

            for(int j=0; j<numOfAuthCows; j++){
                folder.addCow(sn.nextInt());
            }
            folderForest.addFolder(folder);
        }

        for (int i=0; i<numOfConfidentialFolders; i++) {
            int folderId = sn.nextInt();
            Folder folder = new Folder(folderId, FolderType.CONF);            
            int numOfAuthCows = sn.nextInt();
            
            for(int j=0; j<numOfAuthCows; j++){
                folder.addCow(sn.nextInt());
            }
            folderForest.addFolder(folder);
        }
        
        int numOfRemainingLines = sn.nextInt();

        for (int i=0; i<numOfRemainingLines; i++) {
            int parentFolderId = sn.nextInt();
            int childFolderId = sn.nextInt();            
            Folder parentFolder = folderForest.findFolder(parentFolderId);
            Folder childFolder = folderForest.findFolder(childFolderId);            
            
            childFolder.setParent(parentFolder);
            parentFolder.addChild(childFolder);
        }

        HashSet<Integer> unCoolCows = new HashSet<Integer>();
        HashSet<Folder> leafFolders = folderForest.getLeaves();

        for(int i = 0; i < numOfCows; i++) {            
            for(Folder leaf: leafFolders) {
                if(!leaf.hasAccess(i)) {
                    unCoolCows.add(i);
                }    
            }
        }
        
        for(int cow: unCoolCows) {
            System.out.println(cow);
        }
    }

    public static class Forest {
        private HashSet<Folder> folders;

        public Forest() {
            this.folders = new HashSet<Folder>();
        }

        public void addFolder(Folder folder) {
            this.folders.add(folder);
        }

        public HashSet<Folder> getLeaves() {
            HashSet<Folder> leaves = new HashSet<Folder>();

            for(Folder folder: this.folders) {
                if(folder.children.size() == 0) {
                    leaves.add(folder);
                }
            }
            return leaves;
        }

        public Folder findFolder(int id) {
            for(Folder folder: this.folders) {
                if(folder.getId() == id) {
                    return folder;
                }
            }

            return null;
        }
    }

    public static class Folder {
        private int id;
        private FolderType type;
        private Folder parent;
        private HashSet<Folder> children;
        private HashSet<Integer> cows;    

        public Folder(int id, FolderType type) {
            this.id = id;
            this.type = type;
            children = new HashSet<Folder>();
            cows = new HashSet<Integer>();
        }

        public int getId() {
            return id;
        }

        public void setParent(Folder parent) {
            this.parent = parent; 
        }

        public void addCow(int cow){
            this.cows.add(cow);
        }

        public void addChild(Folder child) {
            this.children.add(child);
        }

        @Override
        public int hashCode() {
            return this.id;
        }

        @Override
        public boolean equals(Object obj) {
            Folder Folder = (Folder)obj;
            if(Folder.id == this.id) {
                return true;
            }
            return false;
        }

        public boolean hasAccess(int cow) {      
            if(this.cows.contains(cow)) {
                return true;
            }

            if(this.type == FolderType.SHARED) {
                if(this.parent != null) {
                    if(this.parent.hasAccess(cow)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
