package test;

import java.util.List;
import java.util.Random;

import object.objFood;
import object.objGhost;
import object.objNode;
import object.objPacman;
import interfaceUser.readMapFile;


public class test1 {
	public static void main(String[] args) {

		readMapFile newFile = new readMapFile();
		List<objFood> foodList = newFile.foodList;
		List<objNode> map = newFile.mapList;
		newFile.readFile();
		Random rd = new Random();
		int index;
		objNode notifyAll = new objNode();

		//int index = 390;
		objFood temp = new objFood();
		objPacman objPacman;
		objNode pacman = map.stream().filter(p -> p.objContent == 'P').findFirst().orElse(null);
		objPacman = new objPacman(pacman.coordX, pacman.coordY, 'P', notifyAll);
		
		//objNode []initNode = {map.get(384), map.get(385)};
		objNode[] initNode = map.stream().filter(g -> g.objContent == 'G').toArray(objNode[]::new);
		
		objNode []destinationNode = new objNode[initNode.length];
//		Thread []threadGhost = new Thread[initNode.length];
//		objGhost []objGhost = new objGhost[initNode.length];
		
		for(int i = 0; i < initNode.length; i++){
			index = rd.nextInt(foodList.size() - 1);
			temp = newFile.foodList.get(index);
			destinationNode[i] = objPacman.searchInMapListByCoord(temp.coordX,temp.coordY);
		}
//		for(int i = 0; i < initNode.length; i++){
//			objGhost[i] = new objGhost(initNode[i], destinationNode[i], notifyAll);
//		}
		objGhost objGhost = new objGhost(initNode, destinationNode, notifyAll);
		
		Thread threadGhost = new Thread(objGhost);
		Thread threadPacman = new Thread(objPacman);
////		for(int i = 0; i < initNode.length; i++){
////			threadGhost[i] = new Thread(objGhost[i]);
////		}
//
		threadGhost.start();
		threadPacman.start();
//		for(int i = 0; i < initNode.length; i++){
//			threadGhost[i].start();
//		}

		try {
			threadPacman.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		threadGhost.stop();
		if(newFile.foodList.size() == 0)
			System.out.println("WE WIN!");
		else{
			System.out.println("GAME OVER");
		}
//		objPacman.run();
//		objGhost.run();
	}
}
