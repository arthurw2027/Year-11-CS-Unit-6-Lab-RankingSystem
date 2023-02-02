public class User {
    private int rank;
    private int progress;
    private int[] ranks = {-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8};

    public User(){
        this.rank=-8;
        this.progress=0;
    }
    public int getRank() {
        return rank;
    }
    public int getProgress() {
        return progress;
    }
    public boolean checkRank(int rank){
        for(int validRank:ranks){
            if(validRank==rank) return true;
        }
        return false;
    }
    public int getRankIndex(int rank) {
        for (int i=0;i<ranks.length;i++) {
            if (ranks[i]==rank) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid rank: "+rank);
    }
    public void incProgress(int activityRank){
        if(!checkRank(activityRank)){
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }

        int rankIndex=getRankIndex(rank);
        int activityRankIndex=getRankIndex(activityRank);
        int difference=activityRankIndex-rankIndex;

        if(difference>1){
            progress+=10*difference*difference;
        }
        else if(difference==1){
            progress+=10;
        }
        else if(difference==0){
            progress+=3;
        }
        else if(difference==-1){
            progress+=1;
        }

        while(progress>=100 && rank!=8){
            progress-=100;
            rankIndex++;
            rank=ranks[rankIndex];
        }
        if (rank==8) {
            progress = 0;
        }
    }
    public String toString() {
        return "User{rank=" +rank+", progress="+progress+'}';
    }
}