## Simple Tree

![simpleTree](https://github.com/user-attachments/assets/050d6a65-23d1-4415-8ae7-4cb910bec80b)

## Implementation

### TreeNode class

```java 

package org.example;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    String name;
    List<TreeNode> children;
    public TreeNode(String name){
        this.name = name;
        children = new ArrayList<TreeNode>();
    }
    public void addChild(TreeNode child){
        children.add(child);
    }
    public void display(int level){
        for(int i = 0; i < level; i++){
            System.out.print(" ");
        }
        System.out.println(this.name);
        for(TreeNode node: children){
            node.display(level+1);
        }
    }
}
```

### main class

```java

package org.example;

public class Main {
    public static void main(String[] args) {
        TreeNode drinks  = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");

        drinks.addChild(hot);
        drinks.addChild(cold);

        TreeNode pepsi = new TreeNode("Pepsi");
        TreeNode mirinda = new TreeNode("Mirinda");
        TreeNode cocaCola = new TreeNode("coca-cola");

        cold.addChild(pepsi);
        cold.addChild(mirinda);
        cold.addChild(cocaCola);

        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");

        hot.addChild(tea);
        hot.addChild(coffee);

        drinks.display(0);
    }
}

```
## Output:

```{title}
Drinks
 Hot
  Tea
  Coffee
 Cold
  Pepsi
  Mirinda
  coca-cola
```
