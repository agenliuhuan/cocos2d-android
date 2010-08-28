package com.moandroid.cocos2d.actions;

import com.moandroid.cocos2d.actions.interval.CCIntervalAction;
import com.moandroid.cocos2d.nodes.CCNode;


public class CCRepeatForever extends CCAction {
	   protected CCIntervalAction _other;

	    public static CCRepeatForever action(CCIntervalAction action) {
	        return new CCRepeatForever(action);
	    }


	    protected CCRepeatForever(CCIntervalAction action) {
	        _other = action;
	    }

	    @Override
	    public CCRepeatForever copy() {
	        return new CCRepeatForever(_other.copy());
	    }

	    @Override
	    public void start(CCNode aTarget) {
	        super.start(aTarget);
	        _other.start(_target);
	    }

	    @Override
	    public void step(float dt) {
	        _other.step(dt);
	        if (_other.isDone())
	            _other.start(_target);
	    }


	    @Override
	    public boolean isDone() {
	        return false;
	    }

	    public CCRepeatForever reverse() {
	        return new CCRepeatForever(_other.reverse());
	    }

}
