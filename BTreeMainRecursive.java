import java.util.*;
public class BTreeMainRecursive
{ 
    public static void main(String[] args)
    {
        BTree T=new BTree();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements you want to insert in the BST");
        int z=sc.nextInt();
        System.out.println("Enter the elements");
        for(int i=0;i<z;i++)
        {
            int p=sc.nextInt();
            T.insert(p);
        }
        T.print();
        System.out.println("The smallest of all element is:");
        System.out.println(T.minimum(T.root).data);
        System.out.println("The largest of all element is:");
        System.out.println(T.maximum(T.root).data);
        System.out.println("PreOrder Traversal");
        T.pre();
        System.out.println("PostOrder Traversal");
        T.post();
        System.out.println("Enter the element whose successor is to be found:");
        int h=sc.nextInt();
        System.out.println("The successor of the entered element is:");
        System.out.println((T.successorHelp(h)).data);
        System.out.println("Enter element you want to delete");
        int aa=sc.nextInt();
        T.delete(aa);
        System.out.println("Now the Inorder is:");
        T.print();
    }
}
class BTreeNode
{
    BTreeNode left,right,par;
    int data;
    public BTreeNode()
    {
        this.left=null;
        this.right=null;
        this.par=null;
        data=0;
    }
    public BTreeNode(int d)
    {
        this.left=left;
        this.right=right;
        this.par=par;
        data=d;
    }
}
class BTree
{
    static int c=0;
    BTreeNode root;
    public BTree()
    {
        root=null;
    }
    public void insert(int d)
    {
        root=BSTInsert(d,root,null);
    }
    public BTreeNode BSTInsert(int d,BTreeNode t, BTreeNode p)
    {
        if(t==null)
        {
            t=new BTreeNode(d);
            t.par=p;
        }
        else if(d>t.data)
        {
            t.right=BSTInsert(d,t.right,t);
        }
        else
        {
            t.left=BSTInsert(d,t.left,t);
        }
        return t;
    }
    public BTreeNode maximum(BTreeNode t)
    {
        if(t==null)
        {return t;}
        while(t.right!=null)
        {
            t=t.right;
        }
        return t;
    }
    public BTreeNode minimum(BTreeNode t)
    {
        if(t==null)
        {return t;}
        while(t.left!=null)
        {
            t=t.left;
        }
        return t;
    }
    public BTreeNode successorHelp(int ss)
    {
        return successor(BSTSearch(ss,root));
    }     
    public  BTreeNode successor(BTreeNode t)
    {
    if(t.right!=null)
    {return minimum(t.right);}
    BTreeNode y=t.par;
    while(y!=null && t==y.right)
    {
    t=y;
    y=y.par;
    }
    return y;
    }
    public void print()
    {
        System.out.println("IN-order traversal :");
        inOrderPrint(root);
        System.out.println("");
    }
    public void inOrderPrint(BTreeNode t)
    {
        if(t==null)
        {
            return;
        }
        else if(t!=null)
        {
            inOrderPrint(t.left);
            System.out.print(t.data+" ");
            inOrderPrint(t.right);
        }
    }
    public void pre()
    {
        //System.out.println("IN-order traversal :");
        preOrderPrint(root);
        System.out.println("");
    }
    public void preOrderPrint(BTreeNode t)
    {
        if(t==null)
        {
            return;
        }
        else if(t!=null)
        {
            System.out.print(t.data+" ");
            inOrderPrint(t.left);
            inOrderPrint(t.right);
        }
    }
    public void post()
    {
        //System.out.println("IN-order traversal :");
        postOrderPrint(root);
        System.out.println("");
    }
    public void postOrderPrint(BTreeNode t)
    {
        if(t==null)
        {
            return;
        }
        else if(t!=null)
        {
            inOrderPrint(t.left);
            inOrderPrint(t.right);
            System.out.print(t.data+" ");
        }
    }
    public boolean search(int d)
    {
        if(BSTSearch(d, root) != null)
            return true;
        return false;
    }
    public BTreeNode BSTSearch(int d, BTreeNode t)
    {
        if(t == null || t.data == d)
            return t;
        if(d > t.data)
            return BSTSearch(d, t.right);
        return BSTSearch(d, t.left);
    }
    public void delete(int d)
    {
        root = BSTDelete(d, root);
    }
    public BTreeNode BSTDelete(int d, BTreeNode t)
    {
        if(t ==  null || search(d) == false)
            return null;
        else
        {
            if(d > t.data)
                t.right = BSTDelete(d, t.right);

            else if(d < t.data)
                t.left = BSTDelete(d, t.left);

            else if(d == t.data)
            {
                if(t.left == null)
                    return t.right;
                else if(t.right == null)
                    return t.left; // Takes care of one child AND no children cases simultaneously.
                // Two children
                t.data = minimum(t.right).data;
                t.right = BSTDelete(t.data, t.right);
            }
        }
        return t;
    }
}