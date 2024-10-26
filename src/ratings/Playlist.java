/*
package ratings;

import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;

public class Playlist{

    private BinaryTreeNode<Song> root;
    private Comparator<Song> comparator;
    public Playlist(Comparator<Song> comparator){
        this.comparator=comparator;
        this.root=null;
    }
    public void addSong(Song song){
        this.root =insert(this.root,song);
    }
    private BinaryTreeNode<Song> insert(BinaryTreeNode<Song> node,Song song){
        if (node==null){
            return new BinaryTreeNode<>(song,null,null);
        }
        if (comparator.compare(song, node.getValue())){
            node.setLeft(insert(node.getLeft(),song));
        } else{
            node.setRight(insert(node.getRight(),song));
        }
        return node;
    }
    public BinaryTreeNode<Song> getSongTree(){
        return(this.root);
    }

    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> node){
        if (node==null){
            return null;
        }
        LinkedListNode<Song> LList =getSongList(node.getLeft());
        LinkedListNode<Song> RList =getSongList(node.getRight());
        LinkedListNode<Song> nodeList =new LinkedListNode<>(node.getValue(),null);
        LinkedListNode<Song> last =LList;
        if (last !=null){
            while (last.getNext() !=null){
                last =last.getNext();
            }
            last.setNext(nodeList);
        } else{
            LList =nodeList;
        }
        nodeList.setNext(RList);
        if(LList !=null){
            return LList;
        }else{
            return nodeList;
        }
    }
    public LinkedListNode<Song> getSongList(){
        return getSongList(root);
    }

}

 */
package ratings;

import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;

public class Playlist {

    private Comparator<Song> songComparer;
    private BinaryTreeNode<Song> songTreeRoot;

    public Playlist(Comparator<Song> comparator) {
        this.songComparer = comparator;
        this.songTreeRoot = null;
    }

    public void addSong(Song newSong) {
        this.songTreeRoot = insertIntoBST(songTreeRoot, newSong);
    }

    private BinaryTreeNode<Song> insertIntoBST(BinaryTreeNode<Song> currentNode, Song newSong) {
        if (currentNode == null) {
            return new BinaryTreeNode<>(newSong, null, null);
        }

        if (songComparer.compare(newSong, currentNode.getValue())) {
            currentNode.setLeft(insertIntoBST(currentNode.getLeft(), newSong));
        } else {
            currentNode.setRight(insertIntoBST(currentNode.getRight(), newSong));
        }

        return currentNode;
    }

    public BinaryTreeNode<Song> getSongTree() {
        return songTreeRoot;
    }

    public LinkedListNode<Song> getSongList() {
        return getSongList(songTreeRoot);
    }

    private LinkedListNode<Song> getSongList(BinaryTreeNode<Song> currentNode) {
        if (currentNode == null) {
            return null;
        }

        LinkedListNode<Song> leftSublist = getSongList(currentNode.getLeft());
        LinkedListNode<Song> rightSublist = getSongList(currentNode.getRight());

        LinkedListNode<Song> currentListNode = new LinkedListNode<>(currentNode.getValue(), null);

        // Find the last node of the left sublist
        LinkedListNode<Song> lastNode = leftSublist;
        if (lastNode != null) {
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(currentListNode);
        } else {
            leftSublist = currentListNode;
        }

        currentListNode.setNext(rightSublist);

        if (leftSublist != null) {
            return leftSublist;
        } else {
            return currentListNode;
        }
    }
}



