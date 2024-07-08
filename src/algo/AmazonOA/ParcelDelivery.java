/**
 * @author xuqiluo
 * @date 2024-07-08
 */
package algo.AmazonOA;

public class ParcelDelivery {

    /*
      Amazon has multiple delivery centers for the distribution of its goods.
      In one such center, parcels are arranged in a sequence where the ith parcel has a weight of weight[i].
      A shipment is constituted of a contiguous segment of parcels in this arrangement.
      That is, for 3 parcels arranged with weights [3, 6, 3], a shipment can be formed of parcels with weights [3], [6], [3], [3, 6], [6, 3] and [3, 6, 3] but not with weights [3, 3].
      These shipments are to be loaded for delivery and must be balanced.
      A shipment is said to be balanced if the weight of the last parcel of the shipment is not the maximum weight among all the weights in that shipment.
      For example, shipment with weights [3, 9, 4, 7] is balanced since the last weight is 7, while the maximum shipment weight is 9.
      However, the shipment [4, 7, 2, 7] is not balanced.
      Given the weights of n parcels placed in a sequence, find the maximum number of shipments that can be formed such that each parcel belongs to exactly one shipment,
      each shipment consists of only a contiguous segment of parcels, and each shipment is balanced. If there are no balanced shipments, return 0.
     */

    public static int maxBalancedShipments(int[] weights) {
        int n = weights.length;
        if (n == 0) {
            return 0;
        }

        int count = 0;
        int start = 0;

        while (start < n) {
            int end = start;
            int maxInSegment = weights[start];
            while (end < n && weights[end] <= maxInSegment) {
                maxInSegment = Math.max(maxInSegment, weights[end]);
                end++;
            }

            if (end < n && weights[end] > maxInSegment) {
                count++;
                start = end + 1;
            } else {
                start++;
            }
        }

        return count;
    }
}
