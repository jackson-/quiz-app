package models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

/**
 * Created by devin on 9/8/2015.
 */
public class ProblemGroup implements Parcelable{

    private static List<Problem> mProblems;

    private static int mCurrentProblemId;

    public static final Parcelable.Creator<ProblemGroup> CREATOR = new Parcelable.Creator<ProblemGroup>() {
        public ProblemGroup createFromParcel(Parcel in) {
            return new ProblemGroup(in);
        }

        @Override
        public ProblemGroup[] newArray(int size) {
            return new ProblemGroup[size];
        }

    };

    public ProblemGroup( List<Problem> problems ) {
        mProblems = problems;
    }

    public int getCurrentProblemId() {
        return mCurrentProblemId;
    }

    public void setCurrentProblemId(int mCurrentProblemId) {
        ProblemGroup.mCurrentProblemId = mCurrentProblemId;
    }

    public Problem getProblem( int position ) {
        Problem problem = ProblemGroup.mProblems.get(position);
        return problem;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.v("", "writeToParcel..." + flags);
        dest.writeInt(mCurrentProblemId);
        dest.writeList(mProblems);
    }
    private ProblemGroup(Parcel in) {
        mCurrentProblemId = in.readInt();
        in.readList(mProblems, null);

    }
}


