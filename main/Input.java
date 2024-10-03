package main;

public class Input {
    public boolean up,down,left,right,shift,fire;
    public boolean upHeld,downHeld,leftHeld,rightHeld,shiftHeld,fireHeld;
    public boolean upReleased,downReleased,leftReleased,rightReleased,shiftReleased,fireReleased;
    public Input(){}

    public void update(KeyHandler kh){
        up = false;
        down = false;
        left = false;
        right = false;
        shift = false;
        fire = false;
        upReleased = false;
        downReleased = false;
        leftReleased = false;
        rightReleased = false;
        shiftReleased = false;
        fireReleased = false;
        
        if(fireHeld){
            if(!kh.fire){
                fireHeld = false;
                fireReleased = true;
            }
        }else{
            if(kh.fire){
                fireHeld = true;
                fire = true;
            }
        }
        
        if(shiftHeld){
            if(!kh.shift){
                shiftHeld = false;
                shiftReleased = true;
            }
        }else{
            if(kh.shift){
                shiftHeld = true;
                shift = true;
            }
        }

        if(upHeld){
            if(!kh.up){
                upHeld = false;
                upReleased = true;
            }
        }else{
            if(kh.up){
                upHeld = true;
                up = true;
            }
        }

        if(downHeld){
            if(!kh.down){
                downHeld = false;
                downReleased = true;
            }
        }else{
            if(kh.down){
                downHeld = true;
                down = true;
            }
        }

        if(leftHeld){
            if(!kh.left){
                leftHeld = false;
                leftReleased = true;
            }
        }else{
            if(kh.left){
                leftHeld = true;
                left = true;
            }
        }

        if(rightHeld){
            if(!kh.right){
                rightHeld = false;
                rightReleased = true;
            }
        }else{
            if(kh.right){
                rightHeld = true;
                right = true;
            }
        }

    }
}
