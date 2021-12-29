function connect(root: Node | null): Node | null {
    const connectViaParent = (node: Node, parent: Node) => {
        const nextParent = node;
        while (node) {
            node.next = parent.right;
            if (parent.next)
                node.next.next = parent.next.left;
            node = node.next.next;
            parent = parent.next;
        }
        if (nextParent)
            connectViaParent(nextParent.left, nextParent);
    }
    if (root)
        connectViaParent(root.left, root);
    return root;
};
