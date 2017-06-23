package shop.cart.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ���ﳵ����
 * @author zhangning
 *
 */
public class Cart implements Serializable{
	
	//���ﳵ������
	//������ϣ�Map��Key������Ʒpid,value:������
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	//�����ܼ�
	private double total;

	//car�����и�CartItems����
	public Collection<CartItem> getCartItems(){
		return map.values();	
	}

	public double getTotal() {
		return total;
	}

	//���ﳵ�Ĺ���
	//1.����������ӵ����ﳵ
	public void addCart(CartItem cartItem){
		//�жϹ����ﳵ���Ƿ���ڸù�����
		/*  ����
		 *     ��������  ���ܼ� = �ܼ�+������С��
		 *  ������
		 *     ��map����ӹ�����ܼ� = �ܼ� +������С��   
		 */
		 //��ȡ��ƷID
		   int pid = cartItem.getProduct().getPid();
		 //�жϹ��ﳵ���Ƿ��Ѿ����ڸù�����
		   if(map.containsKey(pid)){
			   //����
			   CartItem _cartItem= map.get(pid);//��ù�����ԭ���Ĺ�����
			   _cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		   }else{
			   //������
			   map.put(pid,cartItem);
		   }
		   //�����ܼƵ�ֵ
		   total += cartItem.getSubtotal();
		
	}
	//2.�ӹ����ﳵ�Ƴ����ﳵ
	public void removeCart(int pid){
		//���������Ƴ�
		 CartItem carItem = map.remove(pid);
		//�ܼ� = �ܼ� - �Ƴ��Ĺ���С��
		total -= carItem.getSubtotal();
		
	}
	
	
	//3.��չ��ﳵ
	public void clearCart(){
		
		//�����й��������
		map.clear();
		//���ܼ�����Ϊ0
		total = 0;
		
	}

}
