package net.mpopov.oservice.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

public class ParamEncoderUtil
{
    public static final String SORT_ORDER_VALUE_DESC = "DESC";

    public static final String SORT_ORDER_VALUE_ASC = "ASC";

    private static final String DEFAULT_SORT_COLUMN = "id";

    private static final int DEFAULT_PAGE_INDEX = 1;

    private static final int DEFAULT_SORT_ORDER = 2;

    public static int getPageIndex(HttpServletRequest request, String tableId)
    {
        int pageIndex = DEFAULT_PAGE_INDEX;

        String paramValue = getParam(request, tableId,
                TableTagParameters.PARAMETER_PAGE);

        if (paramValue != null)
        {
            pageIndex = Integer.parseInt(paramValue);
        }

        return pageIndex;
    }

    public static int getPageIndex(Map<String, String> requestParams,
            String tableId)
    {
        int pageIndex = DEFAULT_PAGE_INDEX;

        String paramValue = getParam(requestParams, tableId,
                TableTagParameters.PARAMETER_PAGE);

        if (paramValue != null)
        {
            pageIndex = Integer.parseInt(paramValue);
        }

        return pageIndex;
    }

    public static String getSortOrder(HttpServletRequest request, String tableId)
    {
        int sortOrder = DEFAULT_SORT_ORDER;

        String paramValue = getParam(request, tableId,
                TableTagParameters.PARAMETER_ORDER);

        if (paramValue != null)
        {
            sortOrder = Integer.parseInt(paramValue);
        }

        return getSortOrderValue(sortOrder);
    }

    public static String getSortOrder(Map<String, String> requestParams,
            String tableId)
    {
        int sortOrder = DEFAULT_SORT_ORDER;

        String paramValue = getParam(requestParams, tableId,
                TableTagParameters.PARAMETER_ORDER);

        if (paramValue != null)
        {
            sortOrder = Integer.parseInt(paramValue);
        }

        return getSortOrderValue(sortOrder);
    }

    private static String getSortOrderValue(int sortOrder)
    {
        String sortOrderValue = SORT_ORDER_VALUE_ASC;
        if (sortOrder != 1)
        {
            sortOrderValue = SORT_ORDER_VALUE_DESC;
        }
        return sortOrderValue;
    }

    public static String getSortColumn(HttpServletRequest request,
            String tableId)
    {
        return getSortColumn(request, tableId, DEFAULT_SORT_COLUMN);
    }

    public static String getSortColumn(Map<String, String> requestParams,
            String tableId)
    {
        return getSortColumn(requestParams, tableId, DEFAULT_SORT_COLUMN);
    }

    public static String getSortColumn(HttpServletRequest request,
            String tableId, String defaultSortColumn)
    {
        String sortColumn = defaultSortColumn;

        String paramValue = getParam(request, tableId,
                TableTagParameters.PARAMETER_SORT);

        if (paramValue != null)
        {
            sortColumn = paramValue;
        }

        return sortColumn;
    }

    public static String getSortColumn(Map<String, String> requestParams,
            String tableId, String defaultSortColumn)
    {
        String sortColumn = defaultSortColumn;

        String paramValue = getParam(requestParams, tableId,
                TableTagParameters.PARAMETER_SORT);

        if (paramValue != null)
        {
            sortColumn = paramValue;
        }

        return sortColumn;
    }

    private static String getParam(HttpServletRequest request, String tableId,
            String tableTagParameter)
    {
        ParamEncoder paramEncoder = new ParamEncoder(tableId);
        String parameterName = paramEncoder
                .encodeParameterName(tableTagParameter);
        return request.getParameter(parameterName);
    }

    private static String getParam(Map<String, String> requestParams,
            String tableId, String tableTagParameter)
    {
        ParamEncoder paramEncoder = new ParamEncoder(tableId);
        String parameterName = paramEncoder
                .encodeParameterName(tableTagParameter);
        return requestParams.get(parameterName);
    }
}
