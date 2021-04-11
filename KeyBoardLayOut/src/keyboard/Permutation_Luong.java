package keyboard;

import static keyboard.Key.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Permutation_Luong<E>{

	private Map<Key, Key> keyToKeyMap;
	
	//Constructor:
	public Permutation_Luong (KeyLayout keyLayout) 
	{
		keyToKeyMap = new HashMap<>();
//		Map<Key, Set<Key>> keyToNeighborMap_QWERTY = getKeyToNeighborMap_QWERTY();
//		
//		for (Map.Entry<Key, Set<Key>> entry: keyToNeighborMap_QWERTY.entrySet()) {
//			Key key = entry.getKey();
//			keyToKeyMap.put(key, key);
//		}
		
	}
	
//	public List<Key> GetNewKeyList(List<Key> originalKeyList) {
//		List<Key> newKeyList = new ArrayList<Key>();
//		for (int i = 0; i < originalKeyList.size(); i++) {
//			newKeyList.add(originalKeyList.get(i));
//		}
//		
//		return newKeyList;
//	}
//	
//	public Set<Key> GetNewSetKey(Set<Key> originalKeySet) {
//		Set<Key> newSetKey = new HashSet<Key>();
//		
//		return newSetKey;
//	}
//	
//	private void setQWERTYToDVORAK () {
//		keyToKeyMap.replace(MINUS, LEFT_BRACKET);
//		keyToKeyMap.replace(EQUALS, RIGHT_BRACKET);
//		
//		keyToKeyMap.replace(Q, TICK);
//		keyToKeyMap.replace(W, COMMA);
//		keyToKeyMap.replace(E, PERIOD);
//		keyToKeyMap.replace(R, P);
//		keyToKeyMap.replace(T, Y);
//		keyToKeyMap.replace(Y, F);
//		keyToKeyMap.replace(U, G);
//		keyToKeyMap.replace(I, C);
//		keyToKeyMap.replace(O, R);
//		keyToKeyMap.replace(P, L);
//		keyToKeyMap.replace(LEFT_BRACKET, FORESLASH);
//		keyToKeyMap.replace(RIGHT_BRACKET, EQUALS);
//		
//		keyToKeyMap.replace(S, O);
//		keyToKeyMap.replace(D, E);
//		keyToKeyMap.replace(F, U);
//		keyToKeyMap.replace(G, I);
//		keyToKeyMap.replace(H, D);
//		keyToKeyMap.replace(J, H);
//		keyToKeyMap.replace(K, T);
//		keyToKeyMap.replace(L, N);
//		keyToKeyMap.replace(SEMICOLON, S);
//		keyToKeyMap.replace(TICK, MINUS);
//		
//		keyToKeyMap.replace(Z, SEMICOLON);
//		keyToKeyMap.replace(X, Q);
//		keyToKeyMap.replace(C, J);
//		keyToKeyMap.replace(V, K);
//		keyToKeyMap.replace(B, X);
//		keyToKeyMap.replace(N, B);
//		keyToKeyMap.replace(M, M);
//		keyToKeyMap.replace(COMMA, W);
//		keyToKeyMap.replace(PERIOD, V);
//		keyToKeyMap.replace(FORESLASH, Z);
//	}
//	
//	private void setQWERTYToColemak () {
//		keyToKeyMap.replace(E, F);
//	}
//	
//	private void setQWERTYToRot13 () {
//		
//	}
//	
//	
//	private static Set<Key> getSet(Key... keys)
//	{
//		return new HashSet<Key>(Arrays.asList(keys));
//	}
}
