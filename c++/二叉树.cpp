struct bTree {
	int key;
	bTree * ltree;
	bTree * rtree;
	bTree() :key(0), ltree(nullptr), rtree(nullptr) {}
};
void create_tree(bTree *&t, vector<int> a, int &d)  //构建二叉树
{
	if (d >= a.size() || a[d] == -1) {
		d++; return;
	}
	t = new bTree();
	t->key = a[d++];
	create_tree(t->ltree, a, d);
	create_tree(t->rtree, a, d);
}
void PreOrder(bTree *t)  //先序非递归
{
	stack<bTree *>s;
	if (t == nullptr)return;
	s.push(t);
	while (!s.empty())
	{
		bTree * temp = s.top();
		cout << temp->key << '\t';
		s.pop();
		if(temp->rtree !=nullptr)
		s.push(temp->rtree);
		if (temp->ltree != nullptr)
		s.push(temp->ltree);
	}	
}
