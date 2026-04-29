package Strivers_dsa.Graph;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class WordLadder127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<int[]> queue=new ArrayDeque<>();
        int[] visited=new int[wordList.size()];
        boolean isEndWordPresent=false;
        for(int i=0;i<wordList.size();i++){
            String word=wordList.get(i);
            if(word.equals(beginWord)) {
                visited[i] = 1;
            }
            if(word.equals(endWord))
                isEndWordPresent=true;
            int distinctLetters =0;
            for(int j=0;j<word.length();j++){
                if(word.charAt(j)!=beginWord.charAt(j))
                    distinctLetters++;
                if(distinctLetters >1)
                    break;
            }
            if(distinctLetters ==1) {
                if(word.equals(endWord))
                    return 2;
                visited[i]=1;
                queue.add(new int[]{i,2});
            }
        }
        if(!isEndWordPresent)
            return 0;
        while (!queue.isEmpty()){
            String word=wordList.get(queue.peek()[0]);
            int level=queue.poll()[1];
            for(int i=0;i<wordList.size();i++){
                if(visited[i]==0){
                    String tempWord=wordList.get(i);
                    int distinctLetters =0;
                    for(int j=0;j<word.length();j++){
                        if(word.charAt(j)!=tempWord.charAt(j))
                            distinctLetters++;
                        if(distinctLetters >1)
                            break;
                    }
                    if(distinctLetters ==1) {
                        if(tempWord.equals(endWord))
                            return level+1;
                        queue.add(new int[]{i,level+1});
                        visited[i]=1;
                    }
                }

            }
        }
        return 0;
    }
}
